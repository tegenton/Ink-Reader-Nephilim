package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.r.AREState;
import tegenton.card.lexer.dfa.state.a.r.t.i.f.a.c.ARTIFACTState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ARState extends AState {
    private static final ARState INSTANCE = new ARState();

    /**
     * @return Singleton instance.
     */
    public static ARState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> AREState.state();
            case 'T' -> new InfixSubstring("TIFAC", 'T', ARTIFACTState::state);
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
