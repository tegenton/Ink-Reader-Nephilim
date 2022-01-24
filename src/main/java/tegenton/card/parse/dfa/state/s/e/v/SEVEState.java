package tegenton.card.parse.dfa.state.s.e.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.e.SEVState;
import tegenton.card.parse.dfa.state.s.e.v.e.SEVENState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SEVEState extends SEVState {
    private static final SEVEState INSTANCE = new SEVEState();

    /**
     * @return Singleton instance.
     */
    public static SEVEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> SEVENState.state();
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
