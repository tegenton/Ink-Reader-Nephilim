package tegenton.card.lexer.dfa.state.s;

import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.s.p.SPEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class SPState extends SState {
    private static final SPState INSTANCE = new SPState();

    /**
     * @return Singleton instance.
     */
    public static SPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> SPEState.state();
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
