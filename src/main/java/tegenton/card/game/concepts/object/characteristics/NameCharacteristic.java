package tegenton.card.game.concepts.object.characteristics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class NameCharacteristic extends Characteristic<List<String>> {
    private final List<String> name;

    private NameCharacteristic(String name) {
        super();
        this.name = new ArrayList<>();
        this.name.add(name);
    }

    public NameCharacteristic(List<String> names) {
        super();
        name = names;
    }

    public static Optional<Characteristic<?>> fromString(String s) {
        String test = s.toLowerCase();
        if (test.startsWith("named ")) {
            NameCharacteristic nameCharacteristic = new NameCharacteristic(s.substring("named ".length()));
            return Optional.of(nameCharacteristic);
        }
        return Optional.empty();
    }

    public static Characteristic<List<String>> nameList(List<String> names) {
        return new NameCharacteristic(names);
    }

    @Override
    public List<String> value() {
        return name;
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.name;
    }
}
