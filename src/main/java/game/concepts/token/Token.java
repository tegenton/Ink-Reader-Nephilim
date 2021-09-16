package game.concepts.token;

import game.concepts.Permanent;
import game.concepts.object.Object;
import game.concepts.object.characteristics.CharacteristicName;
import game.type.subtype.Subtype;

import java.util.List;
import java.util.Optional;

public class Token extends Object implements Permanent {

    protected Token() {
        super();
    }

    public static Token create(String s) {
        Token token = new Token();
        String[] items = s.split(" ");
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase("named")) {
                token.setCharacteristic("named " + items[++i]);
            } else {
                token.setCharacteristic(items[i]);
            }
        }
        if (token.getCharacteristic(CharacteristicName.name).isEmpty()) {
            token.setDefaultName();
        }
        return token;
    }

    private void setDefaultName() {
        StringBuilder name = new StringBuilder();
        if (getCharacteristic(CharacteristicName.subtype).isPresent()) {
            Optional<java.lang.Object> result = this.getCharacteristic(CharacteristicName.subtype);
            if (result.isPresent()) {
                List<Subtype> subtypes = (List<Subtype>) result.get();
                for (Subtype subtype : subtypes) {
                    String temp = subtype.getName();
                    temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
                    name.append(temp).append(" ");
                }
                name = new StringBuilder(name.substring(0, name.length() - 1));
            }
            this.setCharacteristic("named " + name);
        }
    }
}
