package tegenton.card.parse.dfa.state.s.p.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.p.SPEState;
import tegenton.card.parse.dfa.state.s.p.e.l.SPELLState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SPELState extends SPEState {
    private static final SPELState INSTANCE = new SPELState();

    /**
     * @return Singleton instance.
     */
    public static SPELState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> SPELLState.state();
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
