package tegenton.card.lexer.dfa.state.b.l.o.c.k;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.b.BLState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexer.dfa.state.e.ERState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class BLOCKEState extends BLState {
    private static final BLOCKEState INSTANCE = new BLOCKEState();

    /**
     * @return Singleton instance.
     */
    public static BLOCKEState state() {
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
