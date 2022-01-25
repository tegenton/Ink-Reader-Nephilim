package tegenton.card.lexer.dfa.state.b;

import tegenton.card.lexer.dfa.state.BState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.b.a.BANState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.type.SuperType;

import java.util.Optional;

public class BAState extends BState {
    private static final BAState INSTANCE = new BAState();

    /**
     * @return Singleton instance.
     */
    public static BAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new SuffixSubstring("CK", Adverb.BACK);
            case 'N' -> BANState.state();
            case 'S' -> new SuffixSubstring("SIC", SuperType.BASIC);
            case 'T' -> new SuffixSubstring("TTLEFIELD", Zone.BATTLEFIELD);
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
