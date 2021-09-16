package game.type.subtype;

import java.util.HashSet;
import java.util.Set;

public enum EnchantmentType implements Subtype {
    aura,
    cartouche,
    curse,
    rune,
    saga,
    shrine,
    shard;

    static final Set<String> types = new HashSet<>();

    public static boolean contains(String s) {
        if (types.isEmpty()) {
            for (EnchantmentType type : EnchantmentType.values()) {
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
