package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.Subtype;

import java.util.List;
import java.util.Optional;

final class SubtypeCharacteristic extends Characteristic {
    private final List<Subtype> type;

    private SubtypeCharacteristic(final Subtype singleType) {
        super();
        this.type = List.of(singleType);
    }

    private SubtypeCharacteristic(final List<Subtype> subtypeList) {
        super();
        type = subtypeList;
    }

    public static SubtypeCharacteristic fromString(final String s) {
        Optional<Subtype> result;
        for (final Type cardType : Type.values()) {
            result = cardType.fromString(s);
            if (result.isPresent()) {
                return new SubtypeCharacteristic(result.get());
            }
        }
        return null;
    }

    public static Characteristic subtypeList(final List<Subtype> subtypes) {
        return new SubtypeCharacteristic(subtypes);
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.subtype;
    }

    @Override
    public List<Subtype> value() {
        return type;
    }
}
