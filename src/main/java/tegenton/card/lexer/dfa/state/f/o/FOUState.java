package tegenton.card.lexer.dfa.state.f.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.f.FOState;
import tegenton.card.lexer.dfa.state.f.o.u.FOURState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class FOUState extends FOState {
    private static final FOUState INSTANCE = new FOUState();

    /**
     * @return Singleton instance.
     */
    public static FOUState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> FOURState.state();
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
