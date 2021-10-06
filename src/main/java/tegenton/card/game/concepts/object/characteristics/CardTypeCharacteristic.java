package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;

import java.util.EnumSet;
import java.util.Optional;

class CardTypeCharacteristic extends Characteristic<EnumSet<Type>> {
    private final EnumSet<Type> type = EnumSet.noneOf(Type.class);

    private CardTypeCharacteristic(Type type) {
        super();
        this.type.add(type);
    }

    public static Optional<Characteristic<?>> fromString(String s) {
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
    public EnumSet<Type> value() {
        return type;
    }
}
