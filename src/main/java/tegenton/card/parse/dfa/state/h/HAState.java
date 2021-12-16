package tegenton.card.parse.dfa.state.h;

import tegenton.card.parse.dfa.state.HState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.Zone;
import tegenton.card.parse.lexicon.source.target.object.ObjectVerb;
import java.util.Optional;

public class HAState extends HState {
    private static final HAState INSTANCE = new HAState();

    public static HAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("ND", Zone.HAND);
            case 'S' -> new SuffixSubstring("STE", Keyword.HASTE);
            case 'V' -> new SuffixSubstring("VE", ObjectVerb.HAVE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
