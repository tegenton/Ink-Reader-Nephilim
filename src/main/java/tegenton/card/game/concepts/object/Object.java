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

    private <T> Optional<T> getCharacteristic(CharacteristicName name) {
        if (!characteristics.containsKey(name)) {
            return Optional.empty();
        }
        try {
            Characteristic<T> characteristic = (Characteristic<T>) characteristics.get(name);
            return Optional.of(characteristic.value());
        } catch (ClassCastException e) {
            return Optional.empty();
        }
    }

    public Optional<List<String>> getName() {
        return getCharacteristic(CharacteristicName.name);
    }

    protected void setName(List<String> names) {
        characteristics.put(CharacteristicName.name, Characteristic.nameList(names));
    }

    public Optional<EnumSet<Color>> getColor() {
        return getCharacteristic(CharacteristicName.color);
    }

    // TODO: manaCost

    public Optional<EnumSet<Color>> getColorIndicator() {
        return getCharacteristic(CharacteristicName.colorIndicator);
    }

    public Optional<EnumSet<SuperType>> getSuperTypes() {
        return getCharacteristic(CharacteristicName.superType);
    }

    public Optional<EnumSet<Type>> getCardTypes() {
        return getCharacteristic(CharacteristicName.cardType);
    }

    public Optional<List<Subtype>> getSubtypes() {
        return getCharacteristic(CharacteristicName.subtype);
    }

    public Optional<String> getRulesText() {
        return getCharacteristic(CharacteristicName.rulesText);
    }

    // TODO: abilities,
    public Optional<Integer> getPower() {
        Optional<Integer[]> pt = getCharacteristic(CharacteristicName.powerToughness);
        return pt.map(integers -> integers[0]);
    }

    public Optional<Integer> getToughness() {
        Optional<Integer[]> pt = getCharacteristic(CharacteristicName.powerToughness);
        return pt.map(integers -> integers[1]);
    }

    public Optional<Integer> getLoyalty() {
        return getCharacteristic(CharacteristicName.loyalty);
    }

    public Optional<Integer> getHandMod() {
        return getCharacteristic(CharacteristicName.handMod);
    }

    public Optional<Integer> getLifeMod() {
        return getCharacteristic(CharacteristicName.lifeMod);
    }

    protected void setCharacteristic(String item) {
        Characteristic<?> result = Characteristic.fromString(item);
        if (result != null) {
            if (!characteristics.containsKey(result.getName())) {
                characteristics.put(result.getName(), result);
            } else {
                List<Subtype> newTypes = new ArrayList<>();
                newTypes.addAll(getSubtypes().orElse(new ArrayList<>()));
                newTypes.addAll(((Characteristic<List<Subtype>>) result).value());
                characteristics.put(CharacteristicName.subtype, Characteristic.subtypeList(newTypes));
            }
        }
    }

}
