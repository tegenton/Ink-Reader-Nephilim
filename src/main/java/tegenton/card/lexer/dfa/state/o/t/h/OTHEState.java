package tegenton.card.lexer.dfa.state.o.t.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.o.t.OTHState;
import tegenton.card.lexer.dfa.state.o.t.h.e.OTHERState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class OTHEState extends OTHState {
    private static final OTHEState INSTANCE = new OTHEState();

    /**
     * @return Singleton instance.
     */
    public static OTHEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> OTHERState.state();
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
