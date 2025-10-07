package net.nieadni.hyliacraft;

import net.minecraft.text.Text;

public enum HyliaCraftRace {
    HUMAN("human", 20),
    HYLIAN("hylian", 24),
    SKYLOFTIAN("skyloftian", 24),
    ZORA("zora", 20),
    GORON("goron", 40),
    MOGMA("mogma", 16),
    SHEIKAH("sheikah", 28),
    RITO("rito", 18),
    KOKIRI("kokiri", 12);

    public final String id;
    public final int maxHealth;

    HyliaCraftRace(String id, int maxHealth) {
        this.id = id;
        this.maxHealth = maxHealth;
    }

    public Text getName() {
        return Text.translatable("hyliacraft.race.%s.name".formatted(this.id));
    }

    public Text getDescription() {
        return Text.translatable("hyliacraft.race.%s.description".formatted(this.id));
    }

    public Text getAbilities() {
        return Text.translatable("hyliacraft.race.%s.abilities".formatted(this.id));
    }
}
