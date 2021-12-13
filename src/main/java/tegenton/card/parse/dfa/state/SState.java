package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SState extends State {
    private static final SState instance = new SState();

    public static SState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SpaceState.state();
            case '.' -> PeriodState.state();
            default -> throw new IllegalStateException("Cannot transition from SState on " + c);
        };
    }

    @Override
    public Optional<Morpheme> produce(char c) {
        return switch (c) {
            case '\0', ' ', '.' -> Optional.of(Morpheme.S);
            default -> Optional.empty();
        };
    }
}
