package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WState extends State {
    private static final WState instance = new WState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'H' -> WHState.state();
            default -> throw new IllegalStateException("Cannot transition from WState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
