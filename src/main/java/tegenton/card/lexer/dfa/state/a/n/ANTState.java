package tegenton.card.lexer.dfa.state.a.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.ANState;
import tegenton.card.lexer.dfa.state.a.n.t.ANTEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ANTState extends ANState {
    private static final ANTState INSTANCE = new ANTState();

    /**
     * @return Singleton instance.
     */
    public static ANTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ANTEState.state();
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
