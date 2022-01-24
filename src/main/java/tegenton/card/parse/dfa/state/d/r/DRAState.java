package tegenton.card.parse.dfa.state.d.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DRState;
import tegenton.card.parse.dfa.state.d.r.a.DRAWState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class DRAState extends DRState {
    private static final DRAState INSTANCE = new DRAState();

    /**
     * @return Singleton instance.
     */
    public static DRAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'W' -> DRAWState.state();
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
