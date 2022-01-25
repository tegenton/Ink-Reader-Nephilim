package tegenton.card.lexer.dfa.state.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.t.w.TWEState;
import tegenton.card.lexer.dfa.state.t.w.TWOState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TWState extends TState {
    private static final TWState INSTANCE = new TWState();

    /**
     * @return Singleton instance.
     */
    public static TWState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> TWEState.state();
            case 'O' -> TWOState.state();
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
