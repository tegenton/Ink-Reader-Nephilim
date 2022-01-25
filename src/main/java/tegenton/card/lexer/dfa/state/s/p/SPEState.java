package tegenton.card.lexer.dfa.state.s.p;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.s.SPState;
import tegenton.card.lexer.dfa.state.s.p.e.SPELState;
import tegenton.card.lexer.dfa.state.s.p.e.SPENState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class SPEState extends SPState {
    private static final SPEState INSTANCE = new SPEState();

    /**
     * @return Singleton instance.
     */
    public static SPEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> SPELState.state();
            case 'N' -> SPENState.state();
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
