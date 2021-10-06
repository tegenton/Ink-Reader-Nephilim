package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.subtype.Subtype;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Characteristic<T> {
    /*An object’s characteristics are name, mana cost, color, color indicator, card type, subtype,
supertype, rules text, abilities, power, toughness, loyalty, hand modifier, and life modifier. Objects
can have some or all of these characteristics. Any other information about an object isn’t a
characteristic. For example, characteristics don’t include whether a permanent is tapped, a spell’s
target, an object’s owner or controller, what an Aura enchants, and so on.*/
    private static Filter<Characteristic<?>> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Characteristic<?>>>> characteristics;
        characteristics = List.of(NameCharacteristic::fromString, ColorCharacteristic::fromString, CardTypeCharacteristic::fromString, SubtypeCharacteristic::fromString, SuperTypeCharacteristic::fromString, PowerToughnessCharacteristic::fromString);
        filter = new Filter<>(characteristics);
    }

    public static Optional<Characteristic<?>> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }

    public static Characteristic<List<String>> nameList(List<String> names) {
        return NameCharacteristic.nameList(names);
    }

    public static Characteristic<List<Subtype>> subtypeList(List<Subtype> subtypes) {
        return SubtypeCharacteristic.subtypeList(subtypes);
    }

    public abstract T value();

    public abstract CharacteristicName getName();
}
