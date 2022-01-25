package tegenton.card.lexer.dfa.state.c.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.CRState;
import tegenton.card.lexer.dfa.state.c.r.e.CREAState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CREState extends CRState {
    private static final CREState INSTANCE = new CREState();

    /**
     * @return Singleton instance.
     */
    public static CREState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> CREAState.state();
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
