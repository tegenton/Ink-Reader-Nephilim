package tegenton.card.parse.dfa.state.w.h.e;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.w.h.WHEState;
import tegenton.card.parse.lexicon.TriggerWord;
import java.util.Optional;

public final class WHENState extends WHEState {
    private static final WHENState INSTANCE = new WHENState();

    public static WHENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from WHENState on " + c);
        };
    }

    @Override
    public Optional<TriggerWord> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(TriggerWord.WHEN);
            default -> Optional.empty();
        };
    }
}
