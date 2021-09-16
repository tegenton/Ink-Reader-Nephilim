package game.type.subtype;


import java.util.HashSet;
import java.util.Set;

public enum SpellType implements Subtype {
    adventure,
    arcane,
    lesson,
    trap;
    static final Set<String> types = new HashSet<>();

    public static boolean contains(String s) {
        if (types.isEmpty()) {
            for (SpellType type : SpellType.values()) {
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
