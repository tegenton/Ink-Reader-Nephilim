package tegenton.card.game.concepts.object;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.object.characteristics.Characteristic;
import tegenton.card.game.concepts.object.characteristics.CharacteristicName;
import tegenton.card.game.type.SuperType;
import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.Subtype;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * An object is an ability on the stack, a card, a copy of a card, a token, a
 * spell, a permanent, or an emblem.
 */
public abstract class Object {
    private final EnumMap<CharacteristicName, Characteristic> characteristics
            = new EnumMap<>(CharacteristicName.class);

    /**
     * The list of names this object has.
     *
     * @return An empty optional if this object has no name, or an optional
     * containing this object's list of names
     */
    public final Optional<List<String>> getName() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.name);
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null) {
                List<String> names = unknowns.stream()
                        .map(String.class::cast)
                        .collect(Collectors.toList());
                if (!names.isEmpty()) {
                    return Optional.of(names);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Set the names of an object. Overwrites current names.
     *
     * @param names new list of names
     */
    protected void setName(final List<String> names) {
        characteristics.put(CharacteristicName.name,
                Characteristic.nameList(names));
    }

    /**
     * The set of colors this object is. A "colorless" object is different from
     * an object without a color, and has an empty set rather than an empty
     * optional.
     *
     * @return An empty optional if this object has no color characteristic, or
     * an optional containing this object's colors.
     */
    public final Optional<List<Color>> getColor() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.color);
        return getColors(characteristic);
    }

    // manaCost

    /**
     * The set of colors in this object's color indicator.
     *
     * @return An empty optional if this object has no color indicator, or an
     * optional containing this object's color indicator.
     */
    public final Optional<List<Color>> getColorIndicator() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.colorIndicator);
        return getColors(characteristic);
    }

    /**
     * The set of supertypes of this object.
     *
     * @return An empty optional if this object has no supertypes, or an
     * optional containing this object's supertypes.
     */
    public final Optional<List<SuperType>> getSuperTypes() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.superType);
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null) {
                List<SuperType> superTypes = unknowns.stream()
                        .map(SuperType.class::cast)
                        .collect(Collectors.toList());
                if (!superTypes.isEmpty()) {
                    return Optional.of(superTypes);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * The set of types of this object.
     *
     * @return An empty optional if this object has no types, or an optional
     * containing this object's types.
     */
    public final Optional<List<Type>> getCardTypes() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.cardType);
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null) {
                List<Type> types = unknowns.stream()
                        .map(Type.class::cast)
                        .collect(Collectors.toList());
                if (!types.isEmpty()) {
                    return Optional.of(types);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * The list of subtypes of this object. This is a list rather than a set
     * because most cards have their types in a particular order (creatures for
     * example use race then class).
     *
     * @return An empty optional if this object has no subtypes, or an optional
     * containing this object's subtypes.
     */
    public final Optional<List<Subtype>> getSubtypes() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.subtype);
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null) {
                List<Subtype> subtypes = unknowns.stream()
                        .map(Subtype.class::cast)
                        .collect(Collectors.toList());
                if (!subtypes.isEmpty()) {
                    return Optional.of(subtypes);
                }
            }
        }
        return Optional.empty();
    }

    /**
     * The rules text of this object.
     *
     * @return An empty optional if this object has no rules text, or an
     * optional containing this object's rules text.
     */
    public final Optional<String> getRulesText() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.rulesText);
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null && unknowns.size() == 1
                    && unknowns.get(0) instanceof String text) {
                return Optional.of(text);
            }
        }
        return Optional.empty();
    }

    // abilities

    /**
     * The power of this object.
     *
     * @return An empty optional if this object has no power, or an optional
     * containing this object's power.
     */
    public final Optional<Integer> getPower() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.powerToughness);
        return getInteger(characteristic, 0);
    }

    /**
     * The toughness of this object.
     *
     * @return An empty optional if this object has no toughness, or an optional
     * containing this object's toughness.
     */
    public final Optional<Integer> getToughness() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.powerToughness);
        return getInteger(characteristic, 1);
    }

    /**
     * The starting loyalty of this object.
     *
     * @return An empty optional if this object has no starting loyalty, or an
     * optional containing this object's starting loyalty.
     */
    public final Optional<Integer> getLoyalty() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.loyalty);
        return getInteger(characteristic, 0);
    }

    /**
     * The hand modifier of this object.
     *
     * @return An empty optional if this object has no hand modifier, or an
     * optional containing this object's hand modifier.
     */
    public final Optional<Integer> getHandMod() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.handMod);
        return getInteger(characteristic, 0);
    }

    /**
     * The life modifier of this object.
     *
     * @return An empty optional if this object has no life modifier, or an
     * optional containing this object's life modifier.
     */
    public final Optional<Integer> getLifeMod() {
        Characteristic characteristic;
        characteristic = characteristics.get(CharacteristicName.lifeMod);
        return getInteger(characteristic, 0);
    }

    /**
     * Set a characteristic of this object from a string. This is typically used
     * for setting token attributes.
     *
     * @param item a string containing an attribute.
     */
    protected void setCharacteristic(final String item) {
        final Characteristic result = Characteristic.fromString(item);
        if (result != null) {
            if (!characteristics.containsKey(result.getName())) {
                characteristics.put(result.getName(), result);
            } else {
                final List<Subtype> newTypes = new ArrayList<>();
                newTypes.addAll(getSubtypes().orElse(new ArrayList<>()));
                newTypes.addAll(result.value().stream()
                        .map(Subtype.class::cast)
                        .collect(Collectors.toList()));
                characteristics.put(CharacteristicName.subtype,
                        Characteristic.subtypeList(newTypes));
            }
        }
    }

    private Optional<List<Color>>
    getColors(final Characteristic characteristic) {
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null) {
                List<Color> colors = unknowns.stream()
                        .map(Color.class::cast)
                        .collect(Collectors.toList());
                return Optional.of(colors);
            }
        }
        return Optional.empty();
    }

    private Optional<Integer>
    getInteger(final Characteristic characteristic, final int i) {
        if (characteristic != null) {
            List<?> unknowns = characteristic.value();
            if (unknowns != null && unknowns.size() == 2
                    && unknowns.get(i) instanceof Integer integer) {
                return Optional.of(integer);
            }
        }
        return Optional.empty();
    }
}
