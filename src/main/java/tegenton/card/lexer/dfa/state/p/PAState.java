package tegenton.card.lexer.dfa.state.p;

import tegenton.card.lexer.dfa.state.PState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.p.a.PAIState;
import tegenton.card.lexer.dfa.state.p.a.PAYState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class PAState extends PState {
    private static final PAState INSTANCE = new PAState();

    /**
     * @return Singleton instance.
     */
    public static PAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> PAIState.state();
            case 'Y' -> PAYState.state();
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
