package tegenton.card.lexer.dfa.state.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.t.h.THAState;
import tegenton.card.lexer.dfa.state.t.h.THEState;
import tegenton.card.lexer.dfa.state.t.h.THIState;
import tegenton.card.lexer.dfa.state.t.h.THOState;
import tegenton.card.lexer.dfa.state.t.h.THRState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THState extends TState {
    private static final THState INSTANCE = new THState();

    /**
     * @return Singleton instance.
     */
    public static THState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> THAState.state();
            case 'E' -> THEState.state();
            case 'I' -> THIState.state();
            case 'O' -> THOState.state();
            case 'R' -> THRState.state();
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
