package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THREEState extends State {
    private static final THREEState instance = new THREEState();

    public static THREEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from THREEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(EnglishNumber.THREE);
            default -> Optional.empty();
        };
    }
}
