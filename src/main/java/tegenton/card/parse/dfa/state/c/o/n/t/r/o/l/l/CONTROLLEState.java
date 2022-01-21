package tegenton.card.parse.dfa.state.c.o.n.t.r.o.l.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.n.t.r.o.l.CONTROLLState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.dfa.state.e.ERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CONTROLLEState extends CONTROLLState {
    private static final CONTROLLEState INSTANCE = new CONTROLLEState();

    public static CONTROLLEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case 'R' -> ERState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
