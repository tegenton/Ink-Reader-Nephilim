package tegenton.card.lexer.dfa.state.l;

import tegenton.card.lexer.dfa.state.LState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.e.LEAState;
import tegenton.card.lexer.dfa.state.l.e.LESState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class LEState extends LState {
    private static final LEState INSTANCE = new LEState();

    /**
     * @return Singleton instance.
     */
    public static LEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> LEAState.state();
            case 'F' -> new SuffixSubstring("FT", Particle.LEFT);
            case 'S' -> LESState.state();
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
