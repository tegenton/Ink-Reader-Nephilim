package tegenton.card.parse.dfa.state.a.n;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.lexicon.Determiner;
import java.util.Optional;

public class ANYState extends ANState {
    private static final ANYState instance = new ANYState();

    public static ANYState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from ANYState on " + c);
        };
    }

    @Override
    public Optional<Determiner> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.ANY);
            default -> Optional.empty();
        };
    }
}
