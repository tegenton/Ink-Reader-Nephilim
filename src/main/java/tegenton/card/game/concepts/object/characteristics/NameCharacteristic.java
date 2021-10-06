package tegenton.card.game.concepts.object.characteristics;

import java.util.ArrayList;
import java.util.List;

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

    public static NameCharacteristic fromString(String s) {
        String test = s.toLowerCase();
        if (test.startsWith("named ")) {
            return new NameCharacteristic(s.substring("named ".length()));
        }
        return null;
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
