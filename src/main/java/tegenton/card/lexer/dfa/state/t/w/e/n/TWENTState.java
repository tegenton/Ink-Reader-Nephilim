package tegenton.card.lexer.dfa.state.t.w.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.w.e.TWENState;
import tegenton.card.lexer.dfa.state.t.w.e.n.t.TWENTYState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TWENTState extends TWENState {
    private static final TWENTState INSTANCE = new TWENTState();

    /**
     * @return Singleton instance.
     */
    public static TWENTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'Y' -> TWENTYState.state();
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
