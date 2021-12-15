package tegenton.card.parse.dfa.state.c.o.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.CONState;
import tegenton.card.parse.dfa.state.c.o.n.t.CONTRState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CONTState extends CONState {
    private static final CONTState INSTANCE = new CONTState();

    public static CONTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> CONTRState.state();
            default -> throw new IllegalStateException("Cannot transition from CONTState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
