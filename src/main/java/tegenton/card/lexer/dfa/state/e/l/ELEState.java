package tegenton.card.lexer.dfa.state.e.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.ELState;
import tegenton.card.lexer.dfa.state.e.l.e.ELEVState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ELEState extends ELState {
    private static final ELEState INSTANCE = new ELEState();

    /**
     * @return Singleton instance.
     */
    public static ELEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'V' -> ELEVState.state();
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
