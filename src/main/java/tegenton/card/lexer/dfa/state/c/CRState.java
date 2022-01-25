package tegenton.card.lexer.dfa.state.c;

import tegenton.card.lexer.dfa.state.CState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.r.CREState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CRState extends CState {
    private static final CRState INSTANCE = new CRState();

    /**
     * @return Singleton instance.
     */
    public static CRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> CREState.state();
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
