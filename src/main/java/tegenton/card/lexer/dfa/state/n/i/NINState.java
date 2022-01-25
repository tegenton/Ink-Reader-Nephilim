package tegenton.card.lexer.dfa.state.n.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.n.NIState;
import tegenton.card.lexer.dfa.state.n.i.n.NINEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NINState extends NIState {
    private static final NINState INSTANCE = new NINState();

    /**
     * @return Singleton instance.
     */
    public static NINState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> NINEState.state();
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
