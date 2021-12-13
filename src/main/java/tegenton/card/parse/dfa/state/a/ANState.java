package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.n.ANYState;
import tegenton.card.parse.lexicon.Determiner;
import java.util.Optional;

public class ANState extends AState {
    private static final ANState instance = new ANState();

    public static ANState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'Y' -> ANYState.state();
            default -> throw new IllegalStateException("Cannot transition from ANState on " + c);
        };
    }

    @Override
    public Optional<Determiner> produce(char c) {
        if (c == '\0') {
            return Optional.of(Determiner.AN);
        }
        return Optional.empty();
    }
}
