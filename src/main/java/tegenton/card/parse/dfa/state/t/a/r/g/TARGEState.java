package tegenton.card.parse.dfa.state.t.a.r.g;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.a.r.g.e.TARGETState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TARGEState extends State {
    private static final TARGEState instance = new TARGEState();

    public static TARGEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> TARGETState.state();
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
