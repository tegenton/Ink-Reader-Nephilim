package game.type.subtype;

import java.util.HashSet;
import java.util.Set;

public enum ArtifactType implements Subtype {
    clue,
    contraption,
    equipment,
    food,
    fortification,
    gold,
    treasure,
    vehicle;

    static final Set<String> types = new HashSet<>();

    static public boolean contains(String s) {
        if (types.isEmpty()) {
            for (ArtifactType type : ArtifactType.values()) {
                types.add(type.getName());
            }
        }
        return types.contains(s);
    }

    @Override
    public String getName() {
        return this.name();
    }
}
