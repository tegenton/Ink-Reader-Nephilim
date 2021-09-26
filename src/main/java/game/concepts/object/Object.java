package game.concepts.object;

import game.concepts.object.characteristics.Characteristic;
import game.concepts.object.characteristics.CharacteristicName;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Object { // TODO: make abstract (interface?)
    // TODO: card(extends object), permanentCard (extends card, implements permanent (extends object)), spell (extends card), ability, abilityOnStack (extends object)
    /*An object’s characteristics are name, mana cost, color, color indicator, card type, subtype,
supertype, rules text, abilities, power, toughness, loyalty, hand modifier, and life modifier. Objects
can have some or all of these characteristics. Any other information about an object isn’t a
characteristic. For example, characteristics don’t include whether a permanent is tapped, a spell’s
target, an object’s owner or controller, what an Aura enchants, and so on.*/
    private final Map<CharacteristicName, Characteristic> characteristics = new HashMap<>();

    public Optional<java.lang.Object> getCharacteristic(CharacteristicName characteristic) {
        Optional<Characteristic> result = Optional.ofNullable(characteristics.get(characteristic));
        return result.map(Characteristic::value);
    }

    protected void setCharacteristic(String item) {
        Optional<Characteristic> result = Characteristic.fromString(item);
        if (result.isPresent()) {
            if (characteristics.containsKey(result.get().getName())) {
                characteristics.get(result.get().getName()).add(result.get());
            } else {
                characteristics.put(result.get().getName(), result.get());
            }
        }
    }

    public void setCharacteristic(CharacteristicName name, java.lang.Object value) {
        characteristics.put(name, Characteristic.create(name, value));
    }
}
