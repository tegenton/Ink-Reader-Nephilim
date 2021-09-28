package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Optional;

class CardTypeCharacteristic extends Characteristic {
    private final EnumSet<Type> type = EnumSet.noneOf(Type.class);

    private CardTypeCharacteristic(Type type) {
        super();
        this.type.add(type);
    }

    public static Optional<Characteristic> fromString(String s) {
        s = s.toLowerCase();
        try {
            return Optional.of(new CardTypeCharacteristic(Type.valueOf(s)));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.cardType;
    }

    @Override
    public void add(Characteristic characteristic) {
        if (characteristic.getClass() == CardTypeCharacteristic.class) {
            this.type.addAll(((CardTypeCharacteristic) characteristic).type);
        }
    }

    @Override
    public Object value() {
        return type;
    }

    @Override
    public void add(Object value) {
        if (EnumSet.class.isAssignableFrom(value.getClass())) {
            type.addAll((Collection<? extends Type>) value);
        }
    }
}
