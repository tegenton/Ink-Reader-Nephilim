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

    /**
     * Returns an optional containing the artifact type represented by s.
     *
     * @param s string that may contain an artifact type
     * @return artifact type contained in s, if s represents one,
     * otherwise empty
     */
    public static Optional<Subtype> fromString(final String s) {
        for (final ArtifactType type : ArtifactType.values()) {
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
