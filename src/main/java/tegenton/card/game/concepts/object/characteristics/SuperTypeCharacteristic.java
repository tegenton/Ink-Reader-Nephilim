package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.SuperType;

import java.util.EnumSet;

class SuperTypeCharacteristic extends Characteristic<EnumSet<SuperType>> {
    private final EnumSet<SuperType> type = EnumSet.noneOf(SuperType.class);

    private SuperTypeCharacteristic(SuperType type) {
        super();
        this.type.add(type);
    }

    public static SuperTypeCharacteristic fromString(String s) {
        s = s.toLowerCase();
        try {
            return new SuperTypeCharacteristic(SuperType.valueOf(s));
        } catch (IllegalArgumentException e) {
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
