package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.SuperType;
import java.util.EnumSet;

final class SuperTypeCharacteristic extends Characteristic<EnumSet<SuperType>> {
    private final EnumSet<SuperType> type = EnumSet.noneOf(SuperType.class);

    private SuperTypeCharacteristic(final SuperType superType) {
        super();
        this.type.add(superType);
    }

    public static SuperTypeCharacteristic fromString(final String s) {
        try {
            final SuperType superType = SuperType.valueOf(s.toLowerCase());
            return new SuperTypeCharacteristic(superType);
        } catch (final IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.superType;
    }

    @Override
    public EnumSet<SuperType> value() {
        return type;
    }
}
