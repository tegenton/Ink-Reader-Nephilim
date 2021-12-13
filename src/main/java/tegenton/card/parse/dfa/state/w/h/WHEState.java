package tegenton.card.parse.dfa.state.w.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.dfa.state.w.h.e.WHENState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WHEState extends WHState {
    private static final WHEState instance = new WHEState();

    public static WHEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> WHENState.state();
            default -> throw new IllegalStateException("Cannot transition from WHEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
