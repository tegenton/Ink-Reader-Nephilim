package tegenton.card.parse.dfa.state.t.w.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.w.TWEState;
import tegenton.card.parse.dfa.state.t.w.e.n.TWENTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class TWENState extends TWEState {
    private static final TWENState INSTANCE = new TWENState();

    /**
     * @return Singleton instance.
     */
    public static TWENState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> TWENTState.state();
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
