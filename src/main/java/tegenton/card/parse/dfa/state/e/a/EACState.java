package tegenton.card.parse.dfa.state.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.EAState;
import tegenton.card.parse.dfa.state.e.a.c.EACHState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class EACState extends EAState {
    private static final EACState INSTANCE = new EACState();

    /**
     * @return Singleton instance.
     */
    public static EACState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> EACHState.state();
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
