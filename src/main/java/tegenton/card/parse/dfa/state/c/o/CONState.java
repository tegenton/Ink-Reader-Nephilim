package tegenton.card.parse.dfa.state.c.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.COState;
import tegenton.card.parse.dfa.state.c.o.n.CONTState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CONState extends COState {
    private static final CONState INSTANCE = new CONState();

    public static CONState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> CONTState.state();
            default -> throw new IllegalStateException("Cannot transition fron CONState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
