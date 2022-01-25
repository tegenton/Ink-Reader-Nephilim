package tegenton.card.lexer.dfa.state.t.w.e.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.w.e.TWELState;
import tegenton.card.lexer.dfa.state.t.w.e.l.v.TWELVEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TWELVState extends TWELState {
    private static final TWELVState INSTANCE = new TWELVState();

    /**
     * @return Singleton instance.
     */
    public static TWELVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> TWELVEState.state();
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
