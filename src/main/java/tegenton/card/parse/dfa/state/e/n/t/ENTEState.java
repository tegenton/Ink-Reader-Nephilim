package tegenton.card.parse.dfa.state.e.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.n.ENTState;
import tegenton.card.parse.dfa.state.e.n.t.e.ENTERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ENTEState extends ENTState {
    private static final ENTEState INSTANCE = new ENTEState();

    /**
     * @return Singleton instance.
     */
    public static ENTEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> ENTERState.state();
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
