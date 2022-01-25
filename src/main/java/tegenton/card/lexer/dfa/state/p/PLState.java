package tegenton.card.lexer.dfa.state.p;

import tegenton.card.lexer.dfa.state.PState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.p.l.PLAState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class PLState extends PState {
    private static final PLState INSTANCE = new PLState();

    /**
     * @return Singleton instance.
     */
    public static PLState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> PLAState.state();
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
