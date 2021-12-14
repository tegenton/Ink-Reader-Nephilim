package tegenton.card.parse.dfa.state.t.w.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.w.TWEState;
import tegenton.card.parse.dfa.state.t.w.e.l.TWELVState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TWELState extends TWEState {
    private static final TWELState INSTANCE = new TWELState();

    public static TWELState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'V' -> TWELVState.state();
            default -> throw new IllegalStateException("Cannot transition from TWELState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
