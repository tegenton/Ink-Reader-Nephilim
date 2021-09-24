package game.concepts.card;

import game.concepts.permanent.Permanent;
import game.concepts.permanent.State;

import java.util.EnumMap;

public class PermanentCard extends Card implements Permanent {
    private EnumMap<State, Boolean> state = new EnumMap<>(State.class);

    public PermanentCard() {
        for (State category : State.values()) {
            state.put(category, false);
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
