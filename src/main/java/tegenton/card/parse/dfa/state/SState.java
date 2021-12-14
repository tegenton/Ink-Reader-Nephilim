package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.s.SEState;
import tegenton.card.parse.dfa.state.s.SIState;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SState extends State {
    private static final SState INSTANCE = new SState();

    public static SState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> SEState.state();
            case 'I' -> SIState.state();
            case '\0', ' ' -> SpaceState.state();
            case '.' -> PeriodState.state();
            default -> throw new IllegalStateException("Cannot transition from SState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ', '.' -> Optional.of(Morpheme.S);
            default -> Optional.empty();
        };
    }
}
