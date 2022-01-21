package tegenton.card.parse.dfa.state.t.h.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THRState;
import tegenton.card.parse.dfa.state.t.h.r.e.THREEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THREState extends THRState {
    private static final THREState instance = new THREState();

    public static THREState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> THREEState.state();
            default -> throw new IllegalStateException("Cannot transition from THREState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
