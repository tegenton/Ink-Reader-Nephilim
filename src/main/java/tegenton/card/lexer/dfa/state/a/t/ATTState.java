package tegenton.card.lexer.dfa.state.a.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.ATState;
import tegenton.card.lexer.dfa.state.a.t.t.ATTAState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ATTState extends ATState {
    private static final ATTState INSTANCE = new ATTState();

    /**
     * @return Singleton instance.
     */
    public static ATTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> ATTAState.state();
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
