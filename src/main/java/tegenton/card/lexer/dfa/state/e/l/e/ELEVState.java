package tegenton.card.lexer.dfa.state.e.l.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.l.ELEState;
import tegenton.card.lexer.dfa.state.e.l.e.v.ELEVEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ELEVState extends ELEState {
    private static final ELEVState INSTANCE = new ELEVState();

    /**
     * @return Singleton instance.
     */
    public static ELEVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ELEVEState.state();
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
