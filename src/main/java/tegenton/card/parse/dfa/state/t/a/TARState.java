package tegenton.card.parse.dfa.state.t.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TAState;
import tegenton.card.parse.dfa.state.t.a.r.TARGState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TARState extends TAState {
    private static final TARState instance = new TARState();

    public static TARState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'G' -> TARGState.state();
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}