package tegenton.card.parse.dfa.state.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.i.SIXState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SIState extends SState {
    private static final SIState instance = new SIState();

    public static SIState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'X' -> SIXState.state();
            default -> throw new IllegalStateException("Cannot transition from SIState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
