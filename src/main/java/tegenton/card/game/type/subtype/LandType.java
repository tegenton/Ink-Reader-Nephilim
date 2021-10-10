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

    LandType(final String fullName) {
        this.basic = false;
        this.name = fullName;
    }

    LandType() {
        this.basic = false;
        this.name = this.name().substring(0, 1).toUpperCase()
                + this.name().substring(1);
    }

    LandType(final boolean isBasic) {
        this.basic = isBasic;
        this.name = this.name();
    }

    /**
     * Returns an optional containing the land type represented by s.
     *
     * @param s string that may contain a land type
     * @return land type contained in s, if s represents one, otherwise empty
     */
    public static Optional<Subtype> fromString(final String s) {
        for (final LandType type : LandType.values()) {
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

    /**
     * The basic land types are Plains, Island, Swamp, Mountain, and Forest.
     *
     * @return is this type basic?
     */
    public boolean isBasic() {
        return basic;
    }
}
