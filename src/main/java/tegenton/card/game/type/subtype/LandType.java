package tegenton.card.game.type.subtype;

import java.util.Optional;

public enum LandType implements Subtype {
    plains(true),
    island(true),
    swamp(true),
    mountain(true),
    forest(true),
    desert,
    gate,
    lair,
    locus,
    urzas("Urza's"),
    mine,
    powerplant("Power-Plant"),
    tower;

    private final String name;
    private final boolean basic;

    LandType(String name) {
        this.basic = false;
        this.name = name;
    }

    LandType() {
        this.basic = false;
        this.name = this.name().substring(0, 1).toUpperCase() + this.name().substring(1);
    }

    LandType(boolean basic) {
        this.basic = basic;
        this.name = this.name();
    }

    public static Optional<Subtype> fromString(String s) {
        for (LandType type : LandType.values()) {
            if (type.getName().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean isBasic() {
        return basic;
    }
}
