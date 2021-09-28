package tegenton.card.game.type;

import tegenton.card.game.type.subtype.*;

import java.util.Optional;
import java.util.function.Function;

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

    Type(Function<String, Optional<Subtype>> subtypes) {
        this.subtypes = subtypes;
    }

    public Optional<Subtype> fromString(String subtype) {
        if (subtypes != null) {
            return subtypes.apply(subtype);
        }
        return Optional.empty();
    }
}
