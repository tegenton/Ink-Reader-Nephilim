package tegenton.card.lexer.dfa.state.w.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.w.WAState;
import tegenton.card.lexer.dfa.state.w.a.l.WALKState;
import tegenton.card.lexer.dfa.state.w.a.l.WALLState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class WALState extends WAState {
    private static final WALState INSTANCE = new WALState();

    /**
     * @return Singleton instance.
     */
    public static WALState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> WALKState.state();
            case 'L' -> WALLState.state();
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
