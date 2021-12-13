package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.l.ALLState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ALState extends AState {
    private static final ALState instance = new ALState();

    public static ALState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> ALLState.state();
            default -> throw new IllegalStateException("Cannot transition from ALState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
