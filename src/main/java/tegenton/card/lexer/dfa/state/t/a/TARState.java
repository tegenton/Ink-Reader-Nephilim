package tegenton.card.lexer.dfa.state.t.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.TAState;
import tegenton.card.lexer.dfa.state.t.a.r.TARGState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TARState extends TAState {
    private static final TARState INSTANCE = new TARState();

    /**
     * @return Singleton instance.
     */
    public static TARState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'G' -> TARGState.state();
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
