package tegenton.card.lexer.dfa.state.m.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.m.MAState;
import tegenton.card.lexer.dfa.state.m.a.n.MANAState;
import tegenton.card.lexer.dfa.state.m.a.n.MANYState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class MANState extends MAState {
    private static final MANState INSTANCE = new MANState();

    /**
     * @return Singleton instance.
     */
    public static MANState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> MANAState.state();
            case 'Y' -> MANYState.state();
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
