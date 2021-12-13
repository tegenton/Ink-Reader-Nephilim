package tegenton.card.parse.dfa.state.g;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.GREState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GRState extends State {
    private static final GRState instance = new GRState();

    public static GRState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> GREState.state();
            default -> throw new IllegalStateException("Cannot transition from GRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
