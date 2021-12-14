package tegenton.card.parse.dfa.state.t.w.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.w.e.TWENState;
import tegenton.card.parse.dfa.state.t.w.e.n.t.TWENTYState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TWENTState extends TWENState {
    private static final TWENTState INSTANCE = new TWENTState();

    public static TWENTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'Y' -> TWENTYState.state();
            default -> throw new IllegalStateException("Cannot transition from TWENTState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
