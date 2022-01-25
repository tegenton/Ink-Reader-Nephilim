package tegenton.card.lexer.dfa.state.c.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.CAState;
import tegenton.card.lexer.dfa.state.c.a.r.CARDState;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CARState extends CAState {
    private static final CARState INSTANCE = new CARState();

    /**
     * @return Singleton instance.
     */
    public static CARState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> CARDState.state();
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
