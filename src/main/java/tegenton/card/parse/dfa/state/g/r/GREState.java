package tegenton.card.parse.dfa.state.g.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.GRState;
import tegenton.card.parse.dfa.state.g.r.e.GREAState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GREState extends GRState {
    private static final GREState instance = new GREState();

    public static GREState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> GREAState.state();
            default -> throw new IllegalStateException("Cannot transition from GREState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
