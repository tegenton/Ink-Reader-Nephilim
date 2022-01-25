package tegenton.card.lexer.dfa.state.t.w.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.w.TWEState;
import tegenton.card.lexer.dfa.state.t.w.e.l.TWELVState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TWELState extends TWEState {
    private static final TWELState INSTANCE = new TWELState();

    /**
     * @return Singleton instance.
     */
    public static TWELState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'V' -> TWELVState.state();
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
