package tegenton.card.lexer.dfa.state.e;

import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.l.ELEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ELState extends EState {
    private static final ELState INSTANCE = new ELState();

    /**
     * @return Singleton instance.
     */
    public static ELState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ELEState.state();
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
