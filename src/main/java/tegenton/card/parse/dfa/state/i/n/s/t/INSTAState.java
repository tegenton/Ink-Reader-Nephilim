package tegenton.card.parse.dfa.state.i.n.s.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.s.INSTState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.INSTANState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INSTAState extends INSTState {
    private static final INSTAState INSTANCE = new INSTAState();

    /**
     * @return Singleton instance.
     */
    public static INSTAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> INSTANState.state();
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
