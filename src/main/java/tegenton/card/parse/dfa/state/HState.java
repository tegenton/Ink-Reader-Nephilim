package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.h.HAState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class HState extends State {
    private static final HState INSTANCE = new HState();

    public static HState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> HAState.state();
            default -> throw new IllegalStateException("Cannot transition from HState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
