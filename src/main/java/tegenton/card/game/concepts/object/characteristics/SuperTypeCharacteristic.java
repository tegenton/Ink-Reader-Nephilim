package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.SuperType;

import java.util.EnumSet;
import java.util.Optional;

class SuperTypeCharacteristic extends Characteristic<EnumSet<SuperType>> {
    private final EnumSet<SuperType> type = EnumSet.noneOf(SuperType.class);

    private SuperTypeCharacteristic(SuperType type) {
        super();
        this.type.add(type);
    }

    public static Optional<Characteristic<?>> fromString(String s) {
        s = s.toLowerCase();
        try {
            return Optional.of(new SuperTypeCharacteristic(SuperType.valueOf(s)));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
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
