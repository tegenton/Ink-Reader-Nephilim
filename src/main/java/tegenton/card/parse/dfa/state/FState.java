package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.state.f.FLState;
import tegenton.card.parse.dfa.state.f.FOState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FState extends State {
    private static final FState instance = new FState();

    public static FState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> FIState.state();
            case 'L' -> FLState.state();
            case 'O' -> FOState.state();
            default -> throw new IllegalStateException("Cannot transition from FState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
