package tegenton.card.game.concepts.card;

import tegenton.card.game.concepts.permanent.Permanent;
import tegenton.card.game.concepts.permanent.State;
import java.util.EnumMap;

/**
 * Within the game rules, the term "permanent card" is used to refer to a card
 * that could be put onto the battlefield. Specifically, it means an artifact,
 * creature, enchantment, land, or planeswalker card. Here it is used to
 * represent one of those cards that is currently on the battlefield.
 */
public class PermanentCard extends Card implements Permanent {
    private final EnumMap<State, Boolean> state = new EnumMap<>(State.class);

    /**
     * Temporary default constructor.
     * Used to test permanent state.
     */
    public PermanentCard() {
        for (final State category : State.values()) {
            state.put(category, false);
        }
    }

    @Override
    public final boolean getState(final State category) {
        return state.get(category);
    }

    @Override
    public final void setState(final State category, final boolean value) {
        state.put(category, value);
    }

    @Override
    public final void toggleState(final State category) {
        state.put(category, !((boolean) state.get(category)));
    }
}
