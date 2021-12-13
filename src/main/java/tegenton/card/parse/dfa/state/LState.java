package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.l.LEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class LState extends State {
    private static final LState instance = new LState();

    public static LState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> LEState.state();
            default -> throw new IllegalStateException("Cannot transition from LState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
