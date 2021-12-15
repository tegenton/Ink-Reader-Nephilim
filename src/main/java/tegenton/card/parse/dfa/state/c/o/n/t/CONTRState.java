package tegenton.card.parse.dfa.state.c.o.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.n.CONTState;
import tegenton.card.parse.dfa.state.c.o.n.t.r.CONTROState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CONTRState extends CONTState {
    private static final CONTRState INSTANCE = new CONTRState();

    public static CONTRState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> CONTROState.state();
            default -> throw new IllegalStateException("Cannot transition from CONTRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
