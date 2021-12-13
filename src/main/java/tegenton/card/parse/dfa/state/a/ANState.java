package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.OState;
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
            case 'O' -> OState.state();
            case 'Y' -> ANYState.state();
            default -> throw new IllegalStateException("Cannot transition from ANState on " + c);
        };
    }

    @Override
    public Optional<Determiner> produce(char c) {
        return switch (c) {
            case 'O', '\0', ' ' -> Optional.of(Determiner.AN);
            default -> Optional.empty();
        };
    }
}
