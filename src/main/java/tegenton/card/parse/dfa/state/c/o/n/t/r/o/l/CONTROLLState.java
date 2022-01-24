package tegenton.card.parse.dfa.state.c.o.n.t.r.o.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.n.t.r.o.CONTROLState;
import tegenton.card.parse.dfa.state.c.o.n.t.r.o.l.l.CONTROLLEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CONTROLLState extends CONTROLState {
    private static final CONTROLLState INSTANCE = new CONTROLLState();

    /**
     * @return Singleton instance.
     */
    public static CONTROLLState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> CONTROLLEState.state();
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
