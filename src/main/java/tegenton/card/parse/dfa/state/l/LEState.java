package tegenton.card.parse.dfa.state.l;

import tegenton.card.parse.dfa.state.LState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.LESState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class LEState extends LState {
    private static final LEState instance = new LEState();

    public static LEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> LESState.state();
            default -> throw new IllegalStateException("Cannot transition from LEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
