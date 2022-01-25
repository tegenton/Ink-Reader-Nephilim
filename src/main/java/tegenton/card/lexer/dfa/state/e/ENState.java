package tegenton.card.lexer.dfa.state.e;

import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.n.ENCState;
import tegenton.card.lexer.dfa.state.e.n.ENDState;
import tegenton.card.lexer.dfa.state.e.n.ENTState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ENState extends EState {
    private static final ENState INSTANCE = new ENState();

    /**
     * @return Singleton instance.
     */
    public static ENState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> ENCState.state();
            case 'D' -> ENDState.state();
            case 'T' -> ENTState.state();
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
