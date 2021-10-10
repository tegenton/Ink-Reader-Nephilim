package tegenton.card.game.type.subtype;


import java.util.Optional;

public enum SpellType implements Subtype {
    adventure,
    arcane,
    lesson,
    trap;

    /**
     * Returns an optional containing the spell type represented by s.
     *
     * @param s string that may contain a spell type
     * @return spell type contained in s, if s represents one,
     * otherwise empty
     */
    public static Optional<Subtype> fromString(final String s) {
        for (final SpellType type : SpellType.values()) {
            if (type.getName().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getName() {
        return this.name().substring(0, 1).toUpperCase()
                + this.name().substring(1);
    }
}
