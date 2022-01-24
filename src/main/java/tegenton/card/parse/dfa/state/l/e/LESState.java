package tegenton.card.parse.dfa.state.l.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.LEState;
import tegenton.card.parse.dfa.state.l.e.s.LESSState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class LESState extends LEState {
    private static final LESState INSTANCE = new LESState();

    /**
     * @return Singleton instance.
     */
    public static LESState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> LESSState.state();
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
