package tegenton.card.game.type.subtype;

import java.util.Optional;

public enum ArtifactType implements Subtype {
    clue,
    contraption,
    equipment,
    food,
    fortification,
    gold,
    treasure,
    vehicle;

    public static Optional<Subtype> fromString(String s) {
        for (ArtifactType type : ArtifactType.values()) {
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
