package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.SuperType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

final class SuperTypeCharacteristic extends Characteristic {
    private final List<SuperType> type = new ArrayList<>();

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
    public List<SuperType> value() {
        return type;
    }
}
