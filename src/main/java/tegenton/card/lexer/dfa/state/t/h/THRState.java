package tegenton.card.lexer.dfa.state.t.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.THState;
import tegenton.card.lexer.dfa.state.t.h.r.THREState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THRState extends THState {
    private static final THRState INSTANCE = new THRState();

    /**
     * @return Singleton instance.
     */
    public static THRState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> THREState.state();
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
