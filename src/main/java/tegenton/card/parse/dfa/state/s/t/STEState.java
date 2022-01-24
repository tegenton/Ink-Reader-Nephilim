package tegenton.card.parse.dfa.state.s.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.STState;
import tegenton.card.parse.dfa.state.s.t.e.STEPState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class STEState extends STState {
    private static final STEState INSTANCE = new STEState();

    /**
     * @return Singleton instance.
     */
    public static STEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'P' -> STEPState.state();
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
