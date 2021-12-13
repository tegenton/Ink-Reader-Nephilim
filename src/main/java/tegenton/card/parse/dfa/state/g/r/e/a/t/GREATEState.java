package tegenton.card.parse.dfa.state.g.r.e.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.e.a.GREATState;
import tegenton.card.parse.dfa.state.g.r.e.a.t.e.GREATERState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GREATEState extends GREATState {
    private static final GREATEState instance = new GREATEState();

    public static GREATEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> GREATERState.state();
            default -> throw new IllegalStateException("Cannot transition from GREATEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
