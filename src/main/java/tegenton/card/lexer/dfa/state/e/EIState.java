package tegenton.card.lexer.dfa.state.e;

import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.i.EIGState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class EIState extends EState {
    private static final EIState INSTANCE = new EIState();

    /**
     * @return Singleton instance.
     */
    public static EIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'G' -> EIGState.state();
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
