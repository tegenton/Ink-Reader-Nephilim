package tegenton.card.lexer.dfa.state.l.e.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.e.LEAState;
import tegenton.card.lexer.dfa.state.l.e.a.s.LEASTState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class LEASState extends LEAState {
    private static final LEASState INSTANCE = new LEASState();

    /**
     * @return Singleton instance.
     */
    public static LEASState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> LEASTState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return super.produce(c);
    }
}
