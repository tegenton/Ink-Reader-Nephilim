package tegenton.card.lexer.dfa.state.o;

import tegenton.card.lexer.dfa.state.OState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.o.t.OTHState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class OTState extends OState {
    private static final OTState INSTANCE = new OTState();

    /**
     * @return Singleton instance.
     */
    public static OTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> OTHState.state();
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
