package tegenton.card.lexer.dfa.state.c.r.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.r.CREState;
import tegenton.card.lexer.dfa.state.c.r.e.a.CREATState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CREAState extends CREState {
    private static final CREAState INSTANCE = new CREAState();

    /**
     * @return Singleton instance.
     */
    public static CREAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> CREATState.state();
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
