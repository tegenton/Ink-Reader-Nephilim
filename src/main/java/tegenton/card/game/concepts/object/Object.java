package tegenton.card.game.concepts.object;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.object.characteristics.Characteristic;
import tegenton.card.game.concepts.object.characteristics.CharacteristicName;
import tegenton.card.game.type.SuperType;
import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.Subtype;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

/**
 * An object is an ability on the stack, a card, a copy of a card, a token, a
 * spell, a permanent, or an emblem.
 */
public abstract class Object {
    private final EnumMap<CharacteristicName, Characteristic<?>> characteristics
            = new EnumMap<>(CharacteristicName.class);

    private <T> Optional<T> getCharacteristic(final CharacteristicName name) {
        if (!characteristics.containsKey(name)) {
            return Optional.empty();
        }
        final Characteristic<T> characteristic;
        characteristic = (Characteristic<T>) characteristics.get(name);
        return Optional.of(characteristic.value());
    }

    /**
     * The list of names this object has.
     *
     * @return An empty optional if this object has no name, or an optional
     * containing this object's list of names
     */
    public final Optional<List<String>> getName() {
        return getCharacteristic(CharacteristicName.name);
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
    public final Optional<EnumSet<Color>> getColor() {
        return getCharacteristic(CharacteristicName.color);
    }

    // manaCost

    /**
     * The set of colors in this object's color indicator.
     *
     * @return An empty optional if this object has no color indicator, or an
     * optional containing this object's color indicator.
     */
    public final Optional<EnumSet<Color>> getColorIndicator() {
        return getCharacteristic(CharacteristicName.colorIndicator);
    }

    /**
     * The set of supertypes of this object.
     *
     * @return An empty optional if this object has no supertypes, or an
     * optional containing this object's supertypes.
     */
    public final Optional<EnumSet<SuperType>> getSuperTypes() {
        return getCharacteristic(CharacteristicName.superType);
    }

    /**
     * The set of types of this object.
     *
     * @return An empty optional if this object has no types, or an optional
     * containing this object's types.
     */
    public final Optional<EnumSet<Type>> getCardTypes() {
        return getCharacteristic(CharacteristicName.cardType);
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
        return getCharacteristic(CharacteristicName.subtype);
    }

    /**
     * The rules text of this object.
     *
     * @return An empty optional if this object has no rules text, or an
     * optional containing this object's rules text.
     */
    public final Optional<String> getRulesText() {
        return getCharacteristic(CharacteristicName.rulesText);
    }

    // abilities

    /**
     * The power of this object.
     *
     * @return An empty optional if this object has no power, or an optional
     * containing this object's power.
     */
    public final Optional<Integer> getPower() {
        final Optional<Integer[]> pt;
        pt = getCharacteristic(CharacteristicName.powerToughness);
        return pt.map(integers -> integers[0]);
    }

    /**
     * The toughness of this object.
     *
     * @return An empty optional if this object has no toughness, or an optional
     * containing this object's toughness.
     */
    public final Optional<Integer> getToughness() {
        final Optional<Integer[]> pt;
        pt = getCharacteristic(CharacteristicName.powerToughness);
        return pt.map(integers -> integers[1]);
    }

    /**
     * The starting loyalty of this object.
     *
     * @return An empty optional if this object has no starting loyalty, or an
     * optional containing this object's starting loyalty.
     */
    public final Optional<Integer> getLoyalty() {
        return getCharacteristic(CharacteristicName.loyalty);
    }

    /**
     * The hand modifier of this object.
     *
     * @return An empty optional if this object has no hand modifier, or an
     * optional containing this object's hand modifier.
     */
    public final Optional<Integer> getHandMod() {
        return getCharacteristic(CharacteristicName.handMod);
    }

    /**
     * The life modifier of this object.
     *
     * @return An empty optional if this object has no life modifier, or an
     * optional containing this object's life modifier.
     */
    public final Optional<Integer> getLifeMod() {
        return getCharacteristic(CharacteristicName.lifeMod);
    }

    /**
     * Set a characteristic of this object from a string. This is typically used
     * for setting token attributes.
     *
     * @param item a string containing an attribute.
     */
    protected void setCharacteristic(final String item) {
        final Characteristic<?> result = Characteristic.fromString(item);
        if (result != null) {
            if (!characteristics.containsKey(result.getName())) {
                characteristics.put(result.getName(), result);
            } else {
                final List<Subtype> newTypes = new ArrayList<>();
                newTypes.addAll(getSubtypes().orElse(new ArrayList<>()));
                newTypes.addAll(((Characteristic<List<Subtype>>) result)
                        .value());
                characteristics.put(CharacteristicName.subtype,
                        Characteristic.subtypeList(newTypes));
            }
        }
    }

}
