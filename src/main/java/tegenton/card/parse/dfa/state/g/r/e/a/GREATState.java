package tegenton.card.parse.dfa.state.g.r.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.e.GREAState;
import tegenton.card.parse.dfa.state.g.r.e.a.t.GREATEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class GREATState extends GREAState {
    private static final GREATState INSTANCE = new GREATState();

    /**
     * @return Singleton instance.
     */
    public static GREATState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> GREATEState.state();
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
