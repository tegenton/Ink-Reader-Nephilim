package tegenton.card.lexer.dfa.state.z.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.z.ZEState;
import tegenton.card.lexer.dfa.state.z.e.r.ZEROState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ZERState extends ZEState {
    private static final ZERState INSTANCE = new ZERState();

    /**
     * @return Singleton instance.
     */
    public static ZERState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> ZEROState.state();
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
