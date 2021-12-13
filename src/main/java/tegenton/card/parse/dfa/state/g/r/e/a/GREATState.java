package tegenton.card.parse.dfa.state.g.r.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.e.GREAState;
import tegenton.card.parse.dfa.state.g.r.e.a.t.GREATEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GREATState extends GREAState {
    private static final GREATState instance = new GREATState();

    public static GREATState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> GREATEState.state();
            default -> throw new IllegalStateException("Cannot transition from GREATState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
