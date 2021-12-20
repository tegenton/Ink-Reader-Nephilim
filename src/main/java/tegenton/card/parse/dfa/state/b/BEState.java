package tegenton.card.parse.dfa.state.b;

import tegenton.card.parse.dfa.state.BState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameVerb;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class BEState extends BState {
    private static final BEState INSTANCE = new BEState();

    public static BEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'C' -> new SuffixSubstring("COME", ObjectVerb.BECOME);
            case 'F' -> new SuffixSubstring("FORE", Preposition.BEFORE);
            case 'Y' -> new SuffixSubstring("YOND", Preposition.BEYOND);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> GameVerb.BE;
            default -> null;
        });
    }
}
