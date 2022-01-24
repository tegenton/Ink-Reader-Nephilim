package tegenton.card.parse.dfa.state.a.t.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.t.ATTState;
import tegenton.card.parse.dfa.state.a.t.t.a.ATTACState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ATTAState extends ATTState {
    private static final ATTAState INSTANCE = new ATTAState();

    /**
     * @return Singleton instance.
     */
    public static ATTAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> ATTACState.state();
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
