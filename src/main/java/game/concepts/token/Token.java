package game.concepts.token;

import game.concepts.object.Object;
import game.concepts.object.characteristics.CharacteristicName;
import game.concepts.permanent.Permanent;
import game.concepts.permanent.State;
import game.type.subtype.Subtype;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class Token extends Object implements Permanent {
    private EnumMap<State, Boolean> state = new EnumMap<>(State.class);

    protected Token() {
        super();
        for (State category : State.values()) {
            state.put(category, false);
        }
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

    @Override
    public boolean getState(State category) {
        return state.get(category);
    }

    @Override
    public void setState(State category, boolean value) {
        state.put(category, value);
    }

    @Override
    public void toggleState(State category) {
        state.put(category, !((boolean) state.get(category)));
    }
}
