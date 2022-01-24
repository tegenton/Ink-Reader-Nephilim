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
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> TWEState.state();
            case 'O' -> TWOState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
