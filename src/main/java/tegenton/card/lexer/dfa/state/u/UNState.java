package tegenton.card.lexer.dfa.state.u;

import tegenton.card.lexer.dfa.state.BState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.UState;
import tegenton.card.lexer.dfa.state.u.n.UNTState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class UNState extends UState {
    private static final UNState INSTANCE = new UNState();

    /**
     * @return Singleton instance.
     */
    public static UNState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> BState.state();
            case 'D' -> new SuffixSubstring("DER", Preposition.UNDER);
            case 'L' -> new SuffixSubstring("LESS", Conjunction.UNLESS);
            case 'S' -> SState.state();
            case 'T' -> UNTState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'B', 'S' -> Adverb.NOT;
            default -> null;
        });
    }
}
