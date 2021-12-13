package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.l.FLYState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FLState extends FState {
    private static final FLState instance = new FLState();

    public static FLState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'Y' -> FLYState.state();
            default -> throw new IllegalStateException("Cannot transition from FLState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
