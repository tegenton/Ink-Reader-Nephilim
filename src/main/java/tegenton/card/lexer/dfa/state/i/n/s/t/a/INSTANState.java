package tegenton.card.lexer.dfa.state.i.n.s.t.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.i.n.s.t.INSTAState;
import tegenton.card.lexer.dfa.state.i.n.s.t.a.n.INSTANCState;
import tegenton.card.lexer.dfa.state.i.n.s.t.a.n.INSTANTState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class INSTANState extends INSTAState {
    private static final INSTANState INSTANCE = new INSTANState();

    /**
     * @return Singleton instance.
     */
    public static INSTANState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> INSTANCState.state();
            case 'T' -> INSTANTState.state();
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
