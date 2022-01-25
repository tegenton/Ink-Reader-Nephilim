package tegenton.card.lexer.dfa.state.d;

import tegenton.card.lexer.dfa.state.d.r.DRAState;
import tegenton.card.lexer.dfa.state.DState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class DRState extends DState {
    private static final DRState INSTANCE = new DRState();

    /**
     * @return Singleton instance.
     */
    public static DRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> DRAState.state();
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
