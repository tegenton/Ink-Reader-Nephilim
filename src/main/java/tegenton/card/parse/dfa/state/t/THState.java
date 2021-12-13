package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.t.h.THAState;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.dfa.state.t.h.THOState;
import tegenton.card.parse.dfa.state.t.h.THRState;
import tegenton.card.parse.dfa.state.t.h.i.THIState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THState extends TState {
    private static final THState instance = new THState();

    public static THState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> THAState.state();
            case 'E' -> THEState.state();
            case 'I' -> THIState.state();
            case 'O' -> THOState.state();
            case 'R' -> THRState.state();
            default -> throw new IllegalStateException("Cannot transition from THState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
