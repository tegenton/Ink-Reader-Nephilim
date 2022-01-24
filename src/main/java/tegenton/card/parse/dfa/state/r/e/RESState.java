package tegenton.card.parse.dfa.state.r.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.dfa.state.r.e.s.RESTState;
import tegenton.card.parse.dfa.state.r.e.s.o.l.RESOLVState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class RESState extends REState {
    private static final RESState INSTANCE = new RESState();

    /**
     * @return Singleton instance.
     */
    public static RESState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> new InfixSubstring("OL", 'V', RESOLVState::state);
            case 'T' -> RESTState.state();
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
