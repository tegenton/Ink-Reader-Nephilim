package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.Subtype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

class SubtypeCharacteristic extends Characteristic {
    private final List<Subtype> type = new ArrayList<>();

    private SubtypeCharacteristic(Subtype type) {
        super();
        this.type.add(type);
    }

    public static Optional<Characteristic> fromString(String s) {
        Optional<Subtype> result;
        for (Type cardType : Type.values()) {
            result = cardType.fromString(s);
            if (result.isPresent()) {
                return Optional.of(new SubtypeCharacteristic(result.get()));
            }
        }
        return Optional.empty();
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.subtype;
    }

    @Override
    public void add(Characteristic characteristic) {
        if (characteristic.getClass() == SubtypeCharacteristic.class) {
            this.type.addAll(((SubtypeCharacteristic) characteristic).type);
        }
    }

    @Override
    public Object value() {
        return type;
    }

    @Override
    public void add(Object value) {
        if (List.class.isAssignableFrom(value.getClass())) {
            type.addAll((Collection<? extends Subtype>) value);
        }
    }
}
