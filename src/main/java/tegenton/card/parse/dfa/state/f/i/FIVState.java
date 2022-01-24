package tegenton.card.parse.dfa.state.f.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.state.f.i.v.FIVEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class FIVState extends FIState {
    private static final FIVState INSTANCE = new FIVState();

    /**
     * @return Singleton instance.
     */
    public static FIVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> FIVEState.state();
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
