package tegenton.card.parse.dfa.state.b;

import tegenton.card.parse.dfa.state.BState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.ColorWord;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class BLState extends BState {
    private static final BLState INSTANCE = new BLState();

    public static BLState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ACK", ColorWord.BLACK);
            case 'O' -> new SuffixSubstring("OCK", ObjectVerb.BLOCK);
            case 'U' -> new SuffixSubstring("UE", ColorWord.BLUE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
