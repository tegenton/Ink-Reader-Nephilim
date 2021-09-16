package game.type.subtype;

import java.util.HashSet;
import java.util.Set;

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

    static final Set<String> types = new HashSet<>();

    static {
        for (LandType type : LandType.values()) {
            types.add(type.getName());
        }
    }

    private final String name;
    private final boolean basic;

    LandType(String name) {
        this.basic = false;
        this.name = name;
    }

    LandType() {
        this.basic = false;
        this.name = this.name();
    }

    LandType(boolean basic) {
        this.basic = basic;
        this.name = this.name();
    }

    public static boolean contains(String s) {
        s = s.toLowerCase();
        return types.contains(s);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean isBasic() {
        return basic;
    }
}
