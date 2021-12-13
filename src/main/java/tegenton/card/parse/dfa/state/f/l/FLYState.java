package tegenton.card.parse.dfa.state.f.l;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.FLState;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FLYState extends FLState {
    private static final FLYState instance = new FLYState();

    public static FLYState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> IState.state();
            default -> throw new IllegalStateException("Cannot transition from FLYState on " + c);
        };
    }

    @Override
    public Optional<Keyword> produce(char c) {
        return switch (c) {
            case 'I' -> Optional.of(Keyword.FLY);
            default -> Optional.empty();
        };
    }
}
