package tegenton.card.parse.dfa.state.t.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.THState;
import tegenton.card.parse.dfa.state.t.h.a.THATState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THAState extends THState {
    private static final THAState instance = new THAState();

    public static THAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> THATState.state();
            default -> throw new IllegalStateException("Cannot transition from THAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
