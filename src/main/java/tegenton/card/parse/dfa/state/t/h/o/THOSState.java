package tegenton.card.parse.dfa.state.t.h.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THOState;
import tegenton.card.parse.dfa.state.t.h.o.s.THOSEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THOSState extends THOState {
    private static final THOSState INSTANCE = new THOSState();

    /**
     * @return Singleton instance.
     */
    public static THOSState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> THOSEState.state();
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
