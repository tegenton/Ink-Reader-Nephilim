package tegenton.card.lexer.dfa.state.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.ENState;
import tegenton.card.lexer.dfa.state.e.n.t.ENTEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ENTState extends ENState {
    private static final ENTState INSTANCE = new ENTState();

    /**
     * @return Singleton instance.
     */
    public static ENTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ENTEState.state();
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
