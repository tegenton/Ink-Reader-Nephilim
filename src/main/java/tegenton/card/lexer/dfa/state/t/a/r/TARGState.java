package tegenton.card.lexer.dfa.state.t.a.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.a.TARState;
import tegenton.card.lexer.dfa.state.t.a.r.g.TARGEState;
import tegenton.card.lexicon.Word;

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
