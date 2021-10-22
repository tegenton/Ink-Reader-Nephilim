package tegenton.card.game.concepts.object.characteristics;

import java.util.ArrayList;
import java.util.List;

final class NameCharacteristic extends Characteristic {
    private final List<String> name;

    private NameCharacteristic(final String singleName) {
        super();
        this.name = new ArrayList<>();
        this.name.add(singleName);
    }

    private NameCharacteristic(final List<String> nameList) {
        super();
        name = nameList;
    }

    public static NameCharacteristic fromString(final String s) {
        final String test = s.toLowerCase();
        if (test.startsWith("named ")) {
            return new NameCharacteristic(s.substring("named ".length()));
        }
        return null;
    }

    public static Characteristic nameList(final List<String> names) {
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
