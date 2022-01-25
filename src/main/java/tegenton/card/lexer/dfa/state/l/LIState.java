package tegenton.card.lexer.dfa.state.l;

import tegenton.card.lexer.dfa.state.LState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Zone;

import java.util.Optional;

public class LIState extends LState {
    private static final LIState INSTANCE = new LIState();

    /**
     * @return Singleton instance.
     */
    public static LIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new SuffixSubstring("BRARY", Zone.LIBRARY);
            case 'F' -> new SuffixSubstring("FE", GameNoun.LIFE);
            case 'K' -> new SuffixSubstring("KEWISE", Adverb.LIKEWISE);
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
