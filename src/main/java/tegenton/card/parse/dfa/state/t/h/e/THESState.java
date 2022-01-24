package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.dfa.state.t.h.e.s.THESEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THESState extends THEState {
    private static final THESState INSTANCE = new THESState();

    /**
     * @return Singleton instance.
     */
    public static THESState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> THESEState.state();
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
