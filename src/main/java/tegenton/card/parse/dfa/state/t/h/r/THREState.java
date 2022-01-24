package tegenton.card.parse.dfa.state.t.h.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THRState;
import tegenton.card.parse.dfa.state.t.h.r.e.THREEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THREState extends THRState {
    private static final THREState INSTANCE = new THREState();

    /**
     * @return Singleton instance.
     */
    public static THREState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> THREEState.state();
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
