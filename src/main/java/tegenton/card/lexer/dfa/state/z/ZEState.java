package tegenton.card.lexer.dfa.state.z;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.ZState;
import tegenton.card.lexer.dfa.state.z.e.ZERState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ZEState extends ZState {
    private static final ZEState INSTANCE = new ZEState();

    /**
     * @return Singleton instance.
     */
    public static ZEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> ZERState.state();
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
