package game.concepts.object.characteristics;

import generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Characteristic {
    /*An object’s characteristics are name, mana cost, color, color indicator, card type, subtype,
supertype, rules text, abilities, power, toughness, loyalty, hand modifier, and life modifier. Objects
can have some or all of these characteristics. Any other information about an object isn’t a
characteristic. For example, characteristics don’t include whether a permanent is tapped, a spell’s
target, an object’s owner or controller, what an Aura enchants, and so on.*/
    private static Filter<Characteristic> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Characteristic>>> characteristics;
        characteristics = List.of(NameCharacteristic::fromString, ColorCharacteristic::fromString, CardTypeCharacteristic::fromString, SubtypeCharacteristic::fromString, SuperTypeCharacteristic::fromString, PowerToughnessCharacteristic::fromString);
        filter = new Filter<>(characteristics);
    }

    public static Optional<Characteristic> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
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
