package tegenton.card.lexer.dfa.state.t.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.THState;
import tegenton.card.lexer.dfa.state.t.h.a.THANState;
import tegenton.card.lexer.dfa.state.t.h.a.THATState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class THAState extends THState {
    private static final THAState INSTANCE = new THAState();

    /**
     * @return Singleton instance.
     */
    public static THAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> THATState.state();
            case 'N' -> THANState.state();
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
