package tegenton.card.parse.dfa.state.t.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.r.THREState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THRState extends State {
    private static final THRState instance = new THRState();

    public static THRState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> THREState.state();
            default -> throw new IllegalStateException("Cannot transition from THRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
