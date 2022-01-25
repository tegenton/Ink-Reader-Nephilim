package tegenton.card.lexer.dfa.state.l.e.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.e.LEAState;
import tegenton.card.lexer.dfa.state.l.e.a.v.LEAVEState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class LEAVState extends LEAState {
    private static final LEAVState INSTANCE = new LEAVState();

    /**
     * @return Singleton instance.
     */
    public static LEAVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> LEAVEState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return super.produce(c);
    }
}
