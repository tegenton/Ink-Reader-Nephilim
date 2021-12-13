package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.m.MOState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class MState extends State {
    private static final MState instance = new MState();

    public static MState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> MOState.state();
            default -> throw new IllegalStateException("Cannot transition from MState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
