package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THRState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THState extends State {
    private static final THState instance = new THState();

    public static THState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> THRState.state();
            default -> throw new IllegalStateException("Cannot transition from THState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
