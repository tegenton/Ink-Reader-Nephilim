package tegenton.card.lexer.dfa.state.c.o.n.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.o.n.CONTState;
import tegenton.card.lexer.dfa.state.c.o.n.t.r.CONTROState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CONTRState extends CONTState {
    private static final CONTRState INSTANCE = new CONTRState();

    /**
     * @return Singleton instance.
     */
    public static CONTRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> CONTROState.state();
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