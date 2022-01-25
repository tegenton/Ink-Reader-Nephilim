package tegenton.card.lexer.dfa.state.w;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.WState;
import tegenton.card.lexer.dfa.state.w.h.WHEState;
import tegenton.card.lexer.dfa.state.w.h.WHIState;
import tegenton.card.lexer.dfa.state.w.h.WHOState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class WHState extends WState {
    private static final WHState INSTANCE = new WHState();

    /**
     * @return Singleton instance.
     */
    public static WHState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> WHEState.state();
            case 'I' -> WHIState.state();
            case 'O' -> WHOState.state();
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
