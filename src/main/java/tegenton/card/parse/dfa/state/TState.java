package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.t.TAState;
import tegenton.card.parse.dfa.state.t.TEState;
import tegenton.card.parse.dfa.state.t.THState;
import tegenton.card.parse.dfa.state.t.TWState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TState extends State {
    private static final TState INSTANCE = new TState();

    public static TState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> TAState.state();
            case 'E' -> TEState.state();
            case 'H' -> THState.state();
            case 'W' -> TWState.state();
            default -> throw new IllegalStateException("Cannot transition from TState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
