package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.l.ALLState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ALState extends AState {
    private static final ALState INSTANCE = new ALState();

    /**
     * @return Singleton instance.
     */
    public static ALState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> ALLState.state();
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
