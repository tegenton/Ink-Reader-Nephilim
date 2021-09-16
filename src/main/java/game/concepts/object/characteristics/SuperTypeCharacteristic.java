package game.concepts.object.characteristics;

import game.type.SuperType;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Optional;

class SuperTypeCharacteristic extends Characteristic {
    private final EnumSet<SuperType> type = EnumSet.noneOf(SuperType.class);

    private SuperTypeCharacteristic(SuperType type) {
        super();
        this.type.add(type);
    }

    public static Optional<Characteristic> fromString(String s) {
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
    public void add(Characteristic characteristic) {
        if (characteristic.getClass() == SuperTypeCharacteristic.class) {
            this.type.addAll(((SuperTypeCharacteristic) characteristic).type);
        }
    }

    @Override
    public Object value() {
        return type;
    }

    @Override
    public void add(Object value) {
        if (EnumSet.class.isAssignableFrom(value.getClass())) {
            type.addAll((Collection<? extends SuperType>) value);
        }
    }
}
