package tegenton.card.lexer.dfa.state.l.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.LEState;
import tegenton.card.lexer.dfa.state.l.e.a.LEASState;
import tegenton.card.lexer.dfa.state.l.e.a.LEAVState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class LEAState extends LEState {
    private static final LEAState INSTANCE = new LEAState();

    /**
     * @return Singleton instance.
     */
    public static LEAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> LEASState.state();
            case 'V' -> LEAVState.state();
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
