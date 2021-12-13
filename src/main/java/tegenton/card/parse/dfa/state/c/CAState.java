package tegenton.card.parse.dfa.state.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.a.CARState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CAState extends State {
    private static final CAState instance = new CAState();

    public static CAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> CARState.state();
            default -> throw new IllegalStateException("Cannot transition from CAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
