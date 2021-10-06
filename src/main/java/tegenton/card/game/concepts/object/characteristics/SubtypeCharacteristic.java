package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.Subtype;

import java.util.List;
import java.util.Optional;

class SubtypeCharacteristic extends Characteristic<List<Subtype>> {
    private final List<Subtype> type;

    private SubtypeCharacteristic(Subtype type) {
        super();
        this.type = List.of(type);
    }

    public SubtypeCharacteristic(List<Subtype> subtypes) {
        super();
        type = subtypes;
    }

    public static SubtypeCharacteristic fromString(String s) {
        Optional<Subtype> result;
        for (Type cardType : Type.values()) {
            result = cardType.fromString(s);
            if (result.isPresent()) {
                return new SubtypeCharacteristic(result.get());
            }
        }
        return null;
    }

    public static Characteristic<List<Subtype>> subtypeList(List<Subtype> subtypes) {
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
