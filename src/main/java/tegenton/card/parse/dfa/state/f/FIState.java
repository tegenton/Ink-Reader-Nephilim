package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.i.FIVState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FIState extends FState {
    private static final FIState instance = new FIState();

    public static FIState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'V' -> FIVState.state();
            default -> throw new IllegalStateException("Cannot transition from FIState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
