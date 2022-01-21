package tegenton.card.parse.dfa.state.t.w.e.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.w.e.TWELState;
import tegenton.card.parse.dfa.state.t.w.e.l.v.TWELVEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class TWELVState extends TWELState {
    private static final TWELVState INSTANCE = new TWELVState();

    public static TWELVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> TWELVEState.state();
            default -> throw new IllegalStateException("Cannot transition from TWELVState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
