package tegenton.card.game.type;

import tegenton.card.game.type.subtype.ArtifactType;
import tegenton.card.game.type.subtype.CreatureType;
import tegenton.card.game.type.subtype.EnchantmentType;
import tegenton.card.game.type.subtype.LandType;
import tegenton.card.game.type.subtype.PlanarType;
import tegenton.card.game.type.subtype.PlaneswalkerType;
import tegenton.card.game.type.subtype.SpellType;
import tegenton.card.game.type.subtype.Subtype;
import java.util.Optional;
import java.util.function.Function;

/**
 * The card types are artifact, conspiracy, creature, dungeon, enchantment,
 * instant, land, phenomenon, plane, planeswalker, scheme, sorcery, tribal, and
 * vanguard.
 */
public enum Type {
    artifact(ArtifactType::fromString),
    conspiracy,
    creature(CreatureType::fromString),
    enchantment(EnchantmentType::fromString),
    instant(SpellType::fromString),
    land(LandType::fromString),
    phenomenon,
    plane(PlanarType::fromString),
    planeswalker(PlaneswalkerType::fromString),
    scheme,
    sorcery(SpellType::fromString),
    tribal(CreatureType::fromString),
    vanguard;

    private final Function<String, Optional<Subtype>> subtypes;

    Type() {
        subtypes = null;
    }

    Type(final Function<String, Optional<Subtype>> subtypeFromString) {
        this.subtypes = subtypeFromString;
    }

    /**
     * Returns the subtype s represents if it is a subtype of this type.
     *
     * @param s string that may contain a subtype
     * @return the represented subtype, or null if s does not contain a subtype
     * of this type
     */
    public Optional<Subtype> fromString(final String s) {
        if (subtypes != null) {
            return subtypes.apply(s);
        }
        return Optional.empty();
    }
}
