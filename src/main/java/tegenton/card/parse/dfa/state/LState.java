package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.l.LAState;
import tegenton.card.parse.dfa.state.l.LEState;
import tegenton.card.parse.dfa.state.l.LIState;
import tegenton.card.parse.dfa.state.l.LOState;
import tegenton.card.parse.lexicon.Word;

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
