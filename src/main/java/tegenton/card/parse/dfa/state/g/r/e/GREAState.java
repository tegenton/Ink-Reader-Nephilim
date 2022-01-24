package tegenton.card.parse.dfa.state.g.r.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.GREState;
import tegenton.card.parse.dfa.state.g.r.e.a.GREATState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class GREAState extends GREState {
    private static final GREAState INSTANCE = new GREAState();

    /**
     * @return Singleton instance.
     */
    public static GREAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> GREATState.state();
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
