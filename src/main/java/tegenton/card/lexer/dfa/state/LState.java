package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.l.LAState;
import tegenton.card.lexer.dfa.state.l.LEState;
import tegenton.card.lexer.dfa.state.l.LIState;
import tegenton.card.lexer.dfa.state.l.LOState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class LState extends State {
    private static final LState INSTANCE = new LState();

    /**
     * @return Singleton instance.
     */
    public static LState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> LAState.state();
            case 'E' -> LEState.state();
            case 'I' -> LIState.state();
            case 'O' -> LOState.state();
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
