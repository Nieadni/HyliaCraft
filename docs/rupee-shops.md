# Rupee shops: adding stock from a datapack

## TL;DR

Any datapack can add items to a HyliaCraft shopkeeper without writing code. Drop a JSON file in
`rupee_costs/` naming an item and a price, and it appears in that trader's shop, sorted cheapest first.
A second directory, `rupee_traders/`, sets per trader options such as when stock refreshes. Only `item`
and `cost` are required; everything else has a sensible default, and `/reload` picks up changes.

---

## Layout

```
my_shop_pack/
├── pack.mcmeta
└── data/
    └── my_shop_pack/          <- your namespace, anything you like
        ├── rupee_costs/
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

`data/my_shop_pack/rupee_costs/golden_apple.json`

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
  "cost": 2500,
  "accepts": ["minecraft:gold_ingot", "minecraft:gold_block"],
  "merchant": "hyliacraft:happy_mask_salesman",
  "max_uses": 3,
  "restocks": false
}
```

| Field | Type | Required | Default | Meaning |
|---|---|---|---|---|
| `item` | item id | yes | | what the player receives |
| `cost` | integer, 0 or more | yes | | price in rupees |
| `accepts` | list of item ids | no | none | extra items the offer will take alongside the rupees, any one of which will do |
| `merchant` | trader id, or a list | no | `hyliacraft:happy_mask_salesman` | who stocks it |
| `max_uses` | integer above 0 | no | `12` | purchases from one trader before it locks |
| `restocks` | boolean | no | `true` | whether a spent entry comes back |

### `accepts` lists alternatives, not requirements

The example above produces **one** offer, whose trade-in slot will take a gold ingot or a gold block. It
does not require both, and it does not appear twice in the list.

A row offering a choice cycles through the alternatives in its icon, a second each, so you can see what
else it would take. HyliaCraft's own Pumpkin Mask entry uses this to accept either a pumpkin or a carved
pumpkin.

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

A file at `data/hyliacraft/rupee_costs/pumpkin_mask.json` in your pack reprices or removes the built in
Pumpkin Mask offer, and the same works for `rupee_traders/`. Normal datapack ordering decides which pack
wins.

## Notes

- Entries are sorted by price, cheapest first, automatically.
- A malformed file is skipped with a warning naming it, and does not stop the rest loading.
- `/reload` applies changes without restarting. Open shops refresh on the next visit.
