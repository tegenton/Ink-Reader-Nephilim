package tegenton.card.lexer.dfa.state.e.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.EIState;
import tegenton.card.lexer.dfa.state.e.i.g.EIGHState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class EIGState extends EIState {
    private static final EIGState INSTANCE = new EIGState();

    /**
     * @return Singleton instance.
     */
    public static EIGState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> EIGHState.state();
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
