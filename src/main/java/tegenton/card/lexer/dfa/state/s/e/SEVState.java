package tegenton.card.lexer.dfa.state.s.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.s.SEState;
import tegenton.card.lexer.dfa.state.s.e.v.SEVEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class SEVState extends SEState {
    private static final SEVState INSTANCE = new SEVState();

    /**
     * @return Singleton instance.
     */
    public static SEVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> SEVEState.state();
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
