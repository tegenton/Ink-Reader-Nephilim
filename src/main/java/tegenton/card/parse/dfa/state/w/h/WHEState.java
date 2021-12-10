package tegenton.card.parse.dfa.state.w.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.w.h.e.WHENState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WHEState extends State {
    private static final WHEState instance = new WHEState();

    public static State state() {
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
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
