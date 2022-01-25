package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.m.AMOState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class AMState extends AState {
    private static final AMState INSTANCE = new AMState();

    /**
     * @return Singleton instance.
     */
    public static AMState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> AMOState.state();
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
