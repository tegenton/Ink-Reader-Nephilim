package tegenton.card.lexer.dfa.state.e;

import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.a.EACState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class EAState extends EState {
    private static final EAState INSTANCE = new EAState();

    /**
     * @return Singleton instance.
     */
    public static EAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> EACState.state();
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
