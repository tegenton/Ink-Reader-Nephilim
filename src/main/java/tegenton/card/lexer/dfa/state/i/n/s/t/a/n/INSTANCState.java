package tegenton.card.lexer.dfa.state.i.n.s.t.a.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.i.n.s.t.a.INSTANState;
import tegenton.card.lexer.dfa.state.i.n.s.t.a.n.c.INSTANCEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class INSTANCState extends INSTANState {
    private static final INSTANCState INSTANCE = new INSTANCState();

    /**
     * @return Singleton instance.
     */
    public static INSTANCState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> INSTANCEState.state();
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
