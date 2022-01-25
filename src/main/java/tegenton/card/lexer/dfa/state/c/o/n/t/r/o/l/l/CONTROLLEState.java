package tegenton.card.lexer.dfa.state.c.o.n.t.r.o.l.l;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.o.n.t.r.o.l.CONTROLLState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexer.dfa.state.e.ERState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CONTROLLEState extends CONTROLLState {
    private static final CONTROLLEState INSTANCE = new CONTROLLEState();

    /**
     * @return Singleton instance.
     */
    public static CONTROLLEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case 'R' -> ERState.state();
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
