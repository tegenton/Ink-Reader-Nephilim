package tegenton.card.parse.dfa.state.t.a.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.a.TARState;
import tegenton.card.parse.dfa.state.t.a.r.g.TARGEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class TARGState extends TARState {
    private static final TARGState INSTANCE = new TARGState();

    /**
     * @return Singleton instance.
     */
    public static TARGState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> TARGEState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
