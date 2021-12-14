package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.t.e.TENState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TEState extends TState {
    private static final TEState INSTANCE = new TEState();

    public static TEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> TENState.state();
            default -> throw new IllegalStateException("Cannot transition from TEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
