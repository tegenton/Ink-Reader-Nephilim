package tegenton.card.parse.dfa.state.w;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.dfa.state.w.h.WHEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WHState extends WState {
    private static final WHState instance = new WHState();

    public static WHState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> WHEState.state();
            default -> throw new IllegalStateException("Cannot transition from WHState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
