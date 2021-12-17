package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.b.BAState;
import tegenton.card.parse.dfa.state.b.BEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.SubordinateConjunction;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class BState extends State {
    private static final BState INSTANCE = new BState();

    public static BState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> BAState.state();
            case 'E' -> BEState.state();
            case 'L' -> new SuffixSubstring("LOCK", ObjectVerb.BLOCK);
            case 'U' -> new SuffixSubstring("UT", SubordinateConjunction.BUT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
