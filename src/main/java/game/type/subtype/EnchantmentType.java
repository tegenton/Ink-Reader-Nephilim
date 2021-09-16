package game.type.subtype;

import java.util.Optional;

public enum EnchantmentType implements Subtype {
    aura,
    cartouche,
    curse,
    rune,
    saga,
    shrine,
    shard;

    public static Optional<Subtype> fromString(String s) {
        for (EnchantmentType type : EnchantmentType.values()) {
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
