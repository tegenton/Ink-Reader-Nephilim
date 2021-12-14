package tegenton.card.parse.dfa.state.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.lexicon.Determiner;
import java.util.Optional;

public class ANYState extends ANState {
    private static final ANYState INSTANCE = new ANYState();

    public static ANYState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
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
