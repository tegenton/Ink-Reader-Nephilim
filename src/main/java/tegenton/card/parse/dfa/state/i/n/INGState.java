package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class INGState extends State {
    private static final INGState instance = new INGState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from INGState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Morpheme.ING);
            default -> Optional.empty();
        };
    }
}
