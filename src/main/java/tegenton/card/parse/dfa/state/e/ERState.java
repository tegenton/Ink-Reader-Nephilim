package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.Morpheme;
import java.util.Optional;

public class ERState extends EState {
    private static final ERState INSTANCE = new ERState();

    public static ERState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException("Cannot transition from ERState on " + c);
        };
    }

    @Override
    public Optional<Morpheme> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Morpheme.ER);
            default -> Optional.empty();
        };
    }
}
