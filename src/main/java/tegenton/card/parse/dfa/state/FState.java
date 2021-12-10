package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.f.FLState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FState extends State {
    private static final FState instance = new FState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> FLState.state();
            default -> throw new IllegalStateException("Cannot transition from FState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
