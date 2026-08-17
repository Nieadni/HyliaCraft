# Rupee shops: adding stock from a datapack

## TL;DR

Any datapack can add items to a HyliaCraft shopkeeper without writing code. Drop a JSON file in
`rupee_trades/` naming an item and a price, and it appears in that trader's shop, sorted cheapest first.
A second directory, `rupee_traders/`, sets per trader options such as when stock refreshes. Only `item`
and `cost` are required; everything else has a sensible default, and `/reload` picks up changes.

---

## Layout

```
my_shop_pack/
├── pack.mcmeta
└── data/
    └── my_shop_pack/          <- your namespace, anything you like
        ├── rupee_trades/
        │   ├── golden_apple.json
        │   └── magic_ring.json
        └── rupee_traders/
            └── happy_mask_salesman.json
```

`pack.mcmeta` for Minecraft 1.21.1:

```json
{
  "pack": {
    "pack_format": 48,
    "description": "Extra shop stock"
  }
}
```

## Selling an item

The smallest useful file. Everything not given takes its default.

`data/my_shop_pack/rupee_trades/golden_apple.json`

```json
{
  "item": "minecraft:enchanted_golden_apple",
  "cost": 500
}
```

Every field:

```json
{
  "item": "somemod:magic_ring",
  "count": 1,
  "cost": 250,
  "accepts": [
    { "item": "minecraft:gold_ingot", "count": 2 },
    "minecraft:gold_block"
  ],
  "merchant": "hyliacraft:happy_mask_salesman",
  "max_uses": 3,
  "restocks": false
}
```

| Field | Type | Required | Default | Meaning |
|---|---|---|---|---|
| `item` | item id | yes | | what the player receives |
| `count` | integer above 0 | no | `1` | how many of it per purchase |
| `cost` | integer, 0 or more | yes | | price in rupees |
| `accepts` | list, see below | no | none | extra items the offer will take alongside the rupees, any one of which will do |
| `merchant` | trader id, or a list | no | `hyliacraft:happy_mask_salesman` | who stocks it |
| `max_uses` | integer above 0 | no | `12` | purchases from one trader before it locks |
| `restocks` | boolean | no | `true` | whether a spent entry comes back |

Any `count`, on the reward or on a trade-in, must fit the item's own stack size. Asking for 32 of
something that stacks to 16 is rejected at load with a warning naming the file, rather than becoming an
offer nobody can ever complete.

### `accepts` lists alternatives, not requirements

**`accepts` is always a list**, even with one entry. Writing it as a bare object is the easiest mistake to
make here, and the file is skipped with a warning rather than loading half of it:

```json
"accepts": { "item": "minecraft:rabbit_foot", "count": 2 }     WRONG, skipped at load
"accepts": [ { "item": "minecraft:rabbit_foot", "count": 2 } ] right
```

The example above produces **one** offer, whose trade-in slot takes *either* two gold ingots *or* one gold
block. It does not require both, and it does not appear twice in the list.

Each entry is written one of two ways:

| Form | Means |
|---|---|
| `"minecraft:gold_block"` | one of that item |
| `{ "item": "minecraft:gold_ingot", "count": 2 }` | two of that item |

Use the short form for anything you want one of, and the object form only when you need a count. They may
be mixed in the same list; a bare id has always meant one, so packs written before counts existed keep
working untouched.

Counts sit **per alternative** for a reason: the case that needs them is usually items of unequal worth,
where a block is worth what nine ingots are. A single count for the whole offer would force those into
separate entries and list the same reward twice.

A row offering a choice cycles through the alternatives in its icon, a second each, so you can see what
else it would take. HyliaCraft's own Pumpkin Mask entry uses this to accept either a pumpkin or a carved
pumpkin.

### Items only, not tags

`item` and `accepts` take concrete item ids. An item **tag** is not accepted, and `#` syntax will not
resolve, so `#minecraft:rabbit_food` fails to load with an "unknown item" warning naming the file.

This catches people out because several natural-sounding ids are tags rather than items:
`minecraft:rabbit_food` is a tag holding carrots and dandelions, while the item you probably want is
`minecraft:rabbit_foot`. List the alternatives out instead, which is what `accepts` is for.

### Prices are paid from the Rupee Pouch

The player hands over a Rupee Pouch, not a pile of coins. The price is taken from the pouch put in the
shop's payment slot, topped up from any other pouches carried if that one cannot cover it, which is why
prices are not limited to what would fit in a trade slot. A cost of 2500 is fine even though a single
pouch holds 999.

Loose rupees are accepted in the same slot for players who have no pouch yet. Coins are consumed to reach
the price and any overpayment comes back as change.

## Configuring a trader

`data/hyliacraft/rupee_traders/happy_mask_salesman.json`

```json
{
  "restock_at": 23000
}
```

| Field | Type | Required | Default | Meaning |
|---|---|---|---|---|
| `restock_at` | integer, 0 to 23999 | no | `23000` | time of day at which stock refreshes |

**The file name is the entity id.** A file called `happy_mask_salesman.json` in the `hyliacraft`
namespace configures `hyliacraft:happy_mask_salesman`. There is no `entity` field.

### The trader roster, today

| Trader id | Added by |
|---|---|
| `hyliacraft:happy_mask_salesman` | HyliaCraft |

That is the whole list, so `merchant` currently has exactly one useful value and leaving it out gives you
the same thing. The roster is code, not data: an entity joins it by calling
`TraderLoader.registerTraderType` at startup, which is why the next section holds.

### Restock times

`restock_at` is a point in the daily cycle, in ticks, not a duration. Every trader refreshes when world
time passes it, once per day. Useful values:

| Ticks | Moment |
|---|---|
| 0 | Dawn, the cycle starts |
| 1000 | Day |
| 6000 | Noon |
| 12000 | Sunset begins |
| 13000 | Night |
| 18000 | Midnight |
| 23000 | Sunrise begins |

Only entries with `restocks: true` come back. Setting `restocks: false` makes an entry a one off for that
individual trader, which is how you gate something rare without a player being locked out of ordinary
stock.

### A trader file cannot create a trader

These files configure shopkeepers that already exist. Whether a mob can trade at all is decided by the
mod that adds it. A file naming anything else loads harmlessly and says so in the log, rather than
turning that mob into a shopkeeper.

The same applies to `merchant`: it chooses among existing traders. An entry naming something that cannot
trade is skipped, and the log names the file so a typo is easy to find.

## Overriding HyliaCraft's own entries

HyliaCraft loads its prices by exactly the same route as your pack, with no special casing. Reusing one
of its file ids replaces that entry.

A file at `data/hyliacraft/rupee_trades/pumpkin_mask.json` in your pack reprices or removes the built in
Pumpkin Mask offer, and the same works for `rupee_traders/`. Normal datapack ordering decides which pack
wins.

## Notes

- Entries are sorted by price, cheapest first, automatically.
- A malformed file is skipped with a warning naming it, and does not stop the rest loading.
- `/reload` applies changes without restarting. Open shops refresh on the next visit.
