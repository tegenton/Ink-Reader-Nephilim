package tegenton.card.lexer.dfa.state.t.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.THState;
import tegenton.card.lexer.dfa.state.t.h.i.THIRState;
import tegenton.card.lexer.dfa.state.t.h.i.s.THISState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THIState extends THState {
    private static final THIState INSTANCE = new THIState();

    /**
     * @return Singleton instance.
     */
    public static THIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> THIRState.state();
            case 'S' -> THISState.state();
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
