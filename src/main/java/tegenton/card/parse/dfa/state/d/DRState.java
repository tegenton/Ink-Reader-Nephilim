package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.r.DRAState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class DRState extends State {
    private static final DRState instance = new DRState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> DRAState.state();
            default -> throw new IllegalStateException("Cannot transition from DRState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
