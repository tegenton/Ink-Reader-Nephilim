package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Punctuation;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class PeriodState extends State {
    private static final PeriodState instance = new PeriodState();

    public static State state() {
        return instance;
    }


    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from PeriodState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Punctuation.PERIOD);
            default -> Optional.empty();
        };
    }
}
