package tegenton.card.parse.dfa.state.b;

import tegenton.card.parse.dfa.state.BState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.a.BANState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Zone;
import tegenton.card.parse.lexicon.game.type.SuperType;

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
