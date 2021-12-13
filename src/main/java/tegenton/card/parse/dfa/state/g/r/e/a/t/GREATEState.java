package tegenton.card.parse.dfa.state.g.r.e.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GREATEState extends State {
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
