package tegenton.card.lexer.dfa.state.c.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.COState;
import tegenton.card.lexer.dfa.state.c.o.n.CONTState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CONState extends COState {
    private static final CONState INSTANCE = new CONState();

    /**
     * @return Singleton instance.
     */
    public static CONState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> CONTState.state();
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
