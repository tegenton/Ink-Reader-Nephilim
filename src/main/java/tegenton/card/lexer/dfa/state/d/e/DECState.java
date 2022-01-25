package tegenton.card.lexer.dfa.state.d.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.d.DEState;
import tegenton.card.lexer.dfa.state.d.e.c.DECKState;
import tegenton.card.lexer.dfa.state.d.e.c.l.a.DECLARState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class DECState extends DEState {
    private static final DECState INSTANCE = new DECState();

    /**
     * @return Singleton instance.
     */
    public static DECState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'K' -> DECKState.state();
            case 'L' -> new InfixSubstring("LA", 'R', DECLARState::state);
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
