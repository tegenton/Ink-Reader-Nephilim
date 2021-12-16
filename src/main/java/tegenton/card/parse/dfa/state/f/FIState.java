package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.i.FIFState;
import tegenton.card.parse.dfa.state.f.i.FIVState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FIState extends FState {
    private static final FIState INSTANCE = new FIState();

    public static FIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'F' -> FIFState.state();
            case 'R' -> new SuffixSubstring("RST", Keyword.FIRST);
            case 'V' -> FIVState.state();
            default -> throw new IllegalStateException(
                    "Cannot transition from FIState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
