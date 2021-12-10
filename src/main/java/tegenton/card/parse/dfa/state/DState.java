package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.d.DRState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class DState extends State {
    private static final DState instance = new DState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> DRState.state();
            default -> throw new IllegalStateException("Cannot transition from DState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
