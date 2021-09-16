package game.concepts.object.characteristics;

import java.util.Optional;

class NameCharacteristic extends Characteristic {
    private String name;

    NameCharacteristic(String name) {
        super();
        this.name = name;
    }

    public static Optional<Characteristic> fromString(String s) {
        String test = s.toLowerCase();
        if (test.startsWith("named ")) {
            NameCharacteristic nameCharacteristic = new NameCharacteristic(s.substring("named ".length()));
            return Optional.of(nameCharacteristic);
        }
        return Optional.empty();
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.name;
    }

    @Override
    public void add(Characteristic characteristic) {
        if (characteristic.getClass() == NameCharacteristic.class) {
            name = (String) characteristic.value();
        }
    }

    @Override
    public Object value() {
        return name;
    }

    @Override
    public void add(Object value) {
        if (value.getClass() == String.class) {
            name = (String) value;
        }
    }
}
