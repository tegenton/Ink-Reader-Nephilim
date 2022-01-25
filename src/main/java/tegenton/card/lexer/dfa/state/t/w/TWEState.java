package tegenton.card.lexer.dfa.state.t.w;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.TWState;
import tegenton.card.lexer.dfa.state.t.w.e.TWELState;
import tegenton.card.lexer.dfa.state.t.w.e.TWENState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TWEState extends TWState {
    private static final TWEState INSTANCE = new TWEState();

    /**
     * @return Singleton instance.
     */
    public static TWEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> TWELState.state();
            case 'N' -> TWENState.state();
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
