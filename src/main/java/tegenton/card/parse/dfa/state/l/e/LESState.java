package tegenton.card.parse.dfa.state.l.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.s.LESSState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class LESState extends State {
    private static final LESState instance = new LESState();

    public static LESState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> LESSState.state();
            default -> throw new IllegalStateException("Cannot transition from LESState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
