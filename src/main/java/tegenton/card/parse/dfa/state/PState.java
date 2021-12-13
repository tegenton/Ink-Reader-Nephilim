package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class PState extends State {
    private static final PState instance = new PState();

    public static PState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> PLState.state();
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
