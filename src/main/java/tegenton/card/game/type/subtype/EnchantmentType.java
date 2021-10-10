package tegenton.card.game.type.subtype;

import java.util.Optional;

public enum EnchantmentType implements Subtype {
    aura,
    cartouche,
    curse,
    rune,
    saga,
    shrine,
    shard;

    /**
     * Returns an optional containing the enchantment type represented by s.
     *
     * @param s string that may contain an enchantment type
     * @return enchantment type contained in s, if s represents one,
     * otherwise empty
     */
    public static Optional<Subtype> fromString(final String s) {
        for (final EnchantmentType type : EnchantmentType.values()) {
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
