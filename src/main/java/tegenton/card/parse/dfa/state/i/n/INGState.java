package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.lexicon.Morpheme;
import java.util.Optional;

public class INGState extends INState {
    private static final INGState instance = new INGState();

    public static INGState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from INGState on " + c);
        };
    }

    @Override
    public Optional<Morpheme> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Morpheme.ING);
            default -> Optional.empty();
        };
    }
}
