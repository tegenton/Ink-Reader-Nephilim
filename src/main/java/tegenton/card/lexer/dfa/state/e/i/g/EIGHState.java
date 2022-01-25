package tegenton.card.lexer.dfa.state.e.i.g;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.i.EIGState;
import tegenton.card.lexer.dfa.state.e.i.g.h.EIGHTState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class EIGHState extends EIGState {
    private static final EIGHState INSTANCE = new EIGHState();

    /**
     * @return Singleton instance.
     */
    public static EIGHState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> EIGHTState.state();
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
