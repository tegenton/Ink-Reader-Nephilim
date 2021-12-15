package tegenton.card.parse.dfa.state.t.w;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TWState;
import tegenton.card.parse.dfa.state.t.w.e.TWELState;
import tegenton.card.parse.dfa.state.t.w.e.TWENState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TWEState extends TWState {
    private static final TWEState INSTANCE = new TWEState();

    public static TWEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> TWELState.state();
            case 'N' -> TWENState.state();
            default -> throw new IllegalStateException("Cannot transition from TWEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}