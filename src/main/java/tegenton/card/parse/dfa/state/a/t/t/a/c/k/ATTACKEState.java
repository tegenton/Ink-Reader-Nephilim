package tegenton.card.parse.dfa.state.a.t.t.a.c.k;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.t.t.a.c.ATTACKState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.e.ATTACKEDState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.e.ATTACKERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ATTACKEState extends ATTACKState {
    private static final ATTACKEState INSTANCE = new ATTACKEState();

    /**
     * @return Singleton instance.
     */
    public static ATTACKEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> ATTACKEDState.state();
            case 'R' -> ATTACKERState.state();
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
