package tegenton.card.parse.dfa.state.o.n;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ONEState extends State {
    private static final ONEState instance = new ONEState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from AState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.ONE);
            default -> Optional.empty();
        };
    }
}
