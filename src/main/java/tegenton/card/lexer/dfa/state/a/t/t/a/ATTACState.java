package tegenton.card.lexer.dfa.state.a.t.t.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.t.t.ATTAState;
import tegenton.card.lexer.dfa.state.a.t.t.a.c.ATTACHState;
import tegenton.card.lexer.dfa.state.a.t.t.a.c.ATTACKState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ATTACState extends ATTAState {
    private static final ATTACState INSTANCE = new ATTACState();

    /**
     * @return Singleton instance.
     */
    public static ATTACState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> ATTACHState.state();
            case 'K' -> ATTACKState.state();
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
