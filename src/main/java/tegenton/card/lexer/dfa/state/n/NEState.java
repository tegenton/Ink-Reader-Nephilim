package tegenton.card.lexer.dfa.state.n;

import tegenton.card.lexer.dfa.state.NState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.n.e.NEWState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class NEState extends NState {
    private static final NEState INSTANCE = new NEState();

    /**
     * @return Singleton instance.
     */
    public static NEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'W' -> NEWState.state();
            case 'X' -> new SuffixSubstring("XT", Adjective.NEXT);
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
