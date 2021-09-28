package tegenton.card.game.type.subtype;


import java.util.Optional;

public enum SpellType implements Subtype {
    adventure,
    arcane,
    lesson,
    trap;

    public static Optional<Subtype> fromString(String s) {
        for (SpellType type : SpellType.values()) {
            if (type.getName().equalsIgnoreCase(s)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String getName() {
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1);
    }
}
