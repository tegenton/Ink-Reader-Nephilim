package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.a.TARState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TAState extends State {
    private static final TAState instance = new TAState();

    public static TAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> TARState.state();
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
