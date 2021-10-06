package tegenton.card.game.concepts.object;

import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.object.characteristics.Characteristic;
import tegenton.card.game.concepts.object.characteristics.CharacteristicName;
import tegenton.card.game.type.SuperType;
import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.Subtype;

import java.util.*;

public abstract class Object {
    // TODO: card(extends object), permanentCard (extends card, implements permanent (extends object)), spell (extends card), ability, abilityOnStack (extends object)
    /*An object’s characteristics are name, mana cost, color, color indicator, card type, subtype,
supertype, rules text, abilities, power, toughness, loyalty, hand modifier, and life modifier. Objects
can have some or all of these characteristics. Any other information about an object isn’t a
characteristic. For example, characteristics don’t include whether a permanent is tapped, a spell’s
target, an object’s owner or controller, what an Aura enchants, and so on.*/
    private final EnumMap<CharacteristicName, Characteristic<?>> characteristics = new EnumMap<>(CharacteristicName.class);

    public Optional<List<String>> getName() {
        if (!characteristics.containsKey(CharacteristicName.name)) {
            return Optional.empty();
        }
        try {
            Characteristic<List<String>> characteristic = (Characteristic<List<String>>) characteristics.get(CharacteristicName.name);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    protected void setName(List<String> names) {
        characteristics.put(CharacteristicName.name, Characteristic.nameList(names));
    }

    public Optional<EnumSet<Color>> getColor() {
        if (!characteristics.containsKey(CharacteristicName.color)) {
            return Optional.empty();
        }
        try {
            Characteristic<EnumSet<Color>> characteristic = (Characteristic<EnumSet<Color>>) characteristics.get(CharacteristicName.color);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    // TODO: manaCost

    public Optional<EnumSet<Color>> getColorIndicator() {
        if (!characteristics.containsKey(CharacteristicName.colorIndicator)) {
            return Optional.empty();
        }
        try {
            Characteristic<EnumSet<Color>> characteristic = (Characteristic<EnumSet<Color>>) characteristics.get(CharacteristicName.colorIndicator);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<EnumSet<SuperType>> getSuperTypes() {
        if (!characteristics.containsKey(CharacteristicName.superType)) {
            return Optional.empty();
        }
        try {
            Characteristic<EnumSet<SuperType>> characteristic = (Characteristic<EnumSet<SuperType>>) characteristics.get(CharacteristicName.superType);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<EnumSet<Type>> getCardTypes() {
        if (!characteristics.containsKey(CharacteristicName.cardType)) {
            return Optional.empty();
        }
        try {
            Characteristic<EnumSet<Type>> characteristic = (Characteristic<EnumSet<Type>>) characteristics.get(CharacteristicName.cardType);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<List<Subtype>> getSubtypes() {
        if (!characteristics.containsKey(CharacteristicName.subtype)) {
            return Optional.empty();
        }
        try {
            Characteristic<List<Subtype>> characteristic = (Characteristic<List<Subtype>>) characteristics.get(CharacteristicName.subtype);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    // TODO: rulesText,
    // TODO: abilities,
    public Optional<Integer> getPower() {
        if (!characteristics.containsKey(CharacteristicName.powerToughness)) {
            return Optional.empty();
        }
        try {
            Characteristic<Integer[]> characteristic = (Characteristic<Integer[]>) characteristics.get(CharacteristicName.powerToughness);
            return Optional.of(characteristic.value()[0]);
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<Integer> getToughness() {
        if (!characteristics.containsKey(CharacteristicName.powerToughness)) {
            return Optional.empty();
        }
        try {
            Characteristic<Integer[]> characteristic = (Characteristic<Integer[]>) characteristics.get(CharacteristicName.powerToughness);
            return Optional.of(characteristic.value()[1]);
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<Integer> getLoyalty() {
        if (!characteristics.containsKey(CharacteristicName.loyalty)) {
            return Optional.empty();
        }
        try {
            Characteristic<Integer> characteristic = (Characteristic<Integer>) characteristics.get(CharacteristicName.loyalty);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<Integer> getHandMod() {
        if (!characteristics.containsKey(CharacteristicName.handMod)) {
            return Optional.empty();
        }
        try {
            Characteristic<Integer> characteristic = (Characteristic<Integer>) characteristics.get(CharacteristicName.handMod);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<Integer> getLifeMod() {
        if (!characteristics.containsKey(CharacteristicName.lifeMod)) {
            return Optional.empty();
        }
        try {
            Characteristic<Integer> characteristic = (Characteristic<Integer>) characteristics.get(CharacteristicName.lifeMod);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    protected void setCharacteristic(String item) {
        Optional<Characteristic<?>> result = Characteristic.fromString(item);
        if (result.isPresent()) {
            if (!characteristics.containsKey(result.get().getName())) {
                characteristics.put(result.get().getName(), result.get());
            } else {
                List<Subtype> newTypes = new ArrayList<>();
                newTypes.addAll(getSubtypes().orElse(new ArrayList<>()));
                newTypes.addAll(((Characteristic<List<Subtype>>) result.get()).value());
                characteristics.put(CharacteristicName.subtype, Characteristic.subtypeList(newTypes));
            }
        }
    }

}
