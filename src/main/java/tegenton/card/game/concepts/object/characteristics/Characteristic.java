package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.subtype.Subtype;

import java.util.List;
import java.util.function.Function;
import tegenton.card.generic.Filter;

/**
 * An object’s characteristics are name, mana cost, color, color indicator, card
 * type, subtype, supertype, rules text, abilities, power, toughness, loyalty,
 * hand modifier, and life modifier. Objects can have some or all of these
 * characteristics. Any other information about an object isn’t a
 * characteristic. For example, characteristics don’t include whether a
 * permanent is tapped, a spell’s target, an object’s owner or controller, what
 * an Aura enchants, and so on.
 *
 * @param <T> type of information contained in the characteristic, such as a
 *            string for name or Color for color
 */
public abstract class Characteristic<T> {
    private static Filter<Characteristic<?>> filter;

    private static void setupFilter() {
        final List<Function<String, Characteristic<?>>> characteristics;
        characteristics = List.of(CardTypeCharacteristic::fromString,
                ColorCharacteristic::fromString,
                NameCharacteristic::fromString,
                PowerToughnessCharacteristic::fromString,
                SubtypeCharacteristic::fromString,
                SuperTypeCharacteristic::fromString);
        filter = new Filter<>(characteristics);
    }

    /**
     * Returns the characteristic represented by s.
     *
     * @param s string which may contain a characteristic
     * @return characteristic contained in s, if s contains a characteristic,
     * otherwise null
     */
    public static Characteristic<?> fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }

    /**
     * Creates a new NameCharacteristic object with the given list of names.
     *
     * @param names the list of names for the new NameCharacteristic
     * @return a NameCharacteristic containing those names
     */
    public static Characteristic<List<String>>
    nameList(final List<String> names) {
        return NameCharacteristic.nameList(names);
    }

    /**
     * Creates a new SubtypeCharacteristic object with the given list of
     * subtypes.
     *
     * @param subtypes the list of names for the new SubtypeCharacteristic
     * @return a SubtypeCharacteristic containing those subtypes
     */
    public static Characteristic<List<Subtype>>
    subtypeList(final List<Subtype> subtypes) {
        return SubtypeCharacteristic.subtypeList(subtypes);
    }

    /**
     * Whatever information is stored in this characteristic.
     *
     * @return Some information
     */
    public abstract T value();

    /**
     * Determine the type of characteristic this object is.
     *
     * @return The relevant CharacteristicName
     */
    public abstract CharacteristicName getName();
}
