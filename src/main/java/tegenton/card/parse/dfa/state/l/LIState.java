package tegenton.card.parse.dfa.state.l;

import tegenton.card.parse.dfa.state.LState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;
import tegenton.card.parse.lexicon.game.Zone;

import java.util.Optional;

public class LIState extends LState {
    private static final LIState INSTANCE = new LIState();

    public static LIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new SuffixSubstring("BRARY", Zone.LIBRARY);
            case 'F' -> new SuffixSubstring("FE", GameNoun.LIFE);
            case 'K' -> new SuffixSubstring("KEWISE", Adverb.LIKEWISE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
