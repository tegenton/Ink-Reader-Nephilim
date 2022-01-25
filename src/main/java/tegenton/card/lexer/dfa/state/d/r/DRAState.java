package tegenton.card.lexer.dfa.state.d.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.d.DRState;
import tegenton.card.lexer.dfa.state.d.r.a.DRAWState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class DRAState extends DRState {
    private static final DRAState INSTANCE = new DRAState();

    /**
     * @return Singleton instance.
     */
    public static DRAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'W' -> DRAWState.state();
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
