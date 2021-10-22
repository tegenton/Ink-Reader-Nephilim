package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;

import java.util.ArrayList;
import java.util.List;

final class CardTypeCharacteristic extends Characteristic {
    private final List<Type> type = new ArrayList<>();

    private CardTypeCharacteristic(final Type singleType) {
        super();
        this.type.add(singleType);
    }

    public static CardTypeCharacteristic fromString(final String s) {
        try {
            return new CardTypeCharacteristic(Type.valueOf(s.toLowerCase()));
        } catch (final IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.cardType;
    }

    @Override
    public List<Type> value() {
        return type;
    }
}
