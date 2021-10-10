package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;

import java.util.EnumSet;

final class CardTypeCharacteristic extends Characteristic<EnumSet<Type>> {
    private final EnumSet<Type> type = EnumSet.noneOf(Type.class);

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
    public EnumSet<Type> value() {
        return type;
    }
}
