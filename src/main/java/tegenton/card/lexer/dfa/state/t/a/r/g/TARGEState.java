package tegenton.card.lexer.dfa.state.t.a.r.g;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.a.r.TARGState;
import tegenton.card.lexer.dfa.state.t.a.r.g.e.TARGETState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TARGEState extends TARGState {
    private static final TARGEState INSTANCE = new TARGEState();

    /**
     * @return Singleton instance.
     */
    public static TARGEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> TARGETState.state();
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
