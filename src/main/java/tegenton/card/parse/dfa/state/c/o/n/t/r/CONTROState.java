package tegenton.card.parse.dfa.state.c.o.n.t.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.n.t.CONTRState;
import tegenton.card.parse.dfa.state.c.o.n.t.r.o.CONTROLState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CONTROState extends CONTRState {
    private static final CONTROState INSTANCE = new CONTROState();

    public static CONTROState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> CONTROLState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
