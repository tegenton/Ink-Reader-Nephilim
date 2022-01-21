package tegenton.card.parse.dfa.state.t.a.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.a.TARState;
import tegenton.card.parse.dfa.state.t.a.r.g.TARGEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TARGState extends TARState {
    private static final TARGState instance = new TARGState();

    public static TARGState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> TARGEState.state();
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
