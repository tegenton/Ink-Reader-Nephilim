package tegenton.card.parse.dfa.state.t.h.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.THState;
import tegenton.card.parse.dfa.state.t.h.i.s.THISState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THIState extends THState {
    private static final THIState instance = new THIState();

    public static THIState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> THISState.state();
            default -> throw new IllegalStateException("Cannot transition from THIState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
