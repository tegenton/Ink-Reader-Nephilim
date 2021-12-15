package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.t.w.TWEState;
import tegenton.card.parse.dfa.state.t.w.TWOState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TWState extends TState {
    private static final TWState INSTANCE = new TWState();

    public static TWState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> TWEState.state();
            case 'O' -> TWOState.state();
            default -> throw new IllegalStateException("Cannot transition from TWState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}