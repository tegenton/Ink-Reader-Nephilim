package tegenton.card.parse.dfa.state.c.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.dfa.state.c.a.r.CARDState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CARState extends CAState {
    private static final CARState instance = new CARState();

    public static CARState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> CARDState.state();
            default -> throw new IllegalStateException("Cannot transition from CARState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
