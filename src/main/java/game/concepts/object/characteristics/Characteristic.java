package game.concepts.object.characteristics;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Characteristic {
    /*An object’s characteristics are name, mana cost, color, color indicator, card type, subtype,
supertype, rules text, abilities, power, toughness, loyalty, hand modifier, and life modifier. Objects
can have some or all of these characteristics. Any other information about an object isn’t a
characteristic. For example, characteristics don’t include whether a permanent is tapped, a spell’s
target, an object’s owner or controller, what an Aura enchants, and so on.*/
    private static final List<Function<String, Optional<Characteristic>>> characteristics;

    static {
        characteristics = List.of(NameCharacteristic::fromString, ColorCharacteristic::fromString, CardTypeCharacteristic::fromString, SubtypeCharacteristic::fromString, SuperTypeCharacteristic::fromString, PowerToughnessCharacteristic::fromString);
    }

    public static Optional<Characteristic> fromString(String s) {
        Optional<Characteristic> result;
        for (Function<String, Optional<Characteristic>> test : characteristics) {
            result = test.apply(s);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    public static Characteristic create(CharacteristicName name, Object value) {
        switch (name) {
            case name:
                return new NameCharacteristic((String) value);
            case powerToughness:

            default:
                return null;
        }
    }

    public abstract CharacteristicName getName();

    public abstract void add(Characteristic characteristic);

    public abstract Object value();

    public abstract void add(Object value);
}
