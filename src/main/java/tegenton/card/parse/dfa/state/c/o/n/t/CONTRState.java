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
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> CONTROState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
