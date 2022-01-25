package tegenton.card.lexer.dfa.state.o;

import tegenton.card.lexer.dfa.state.OState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.o.w.OWNState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class OWState extends OState {
    private static final OWState INSTANCE = new OWState();

    /**
     * @return Singleton instance.
     */
    public static OWState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> OWNState.state();
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
