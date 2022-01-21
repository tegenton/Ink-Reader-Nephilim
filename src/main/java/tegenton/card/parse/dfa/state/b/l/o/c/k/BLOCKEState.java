package tegenton.card.parse.dfa.state.b.l.o.c.k;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.BLState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.dfa.state.e.ERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class BLOCKEState extends BLState {
    private static final BLOCKEState INSTANCE = new BLOCKEState();

    public static BLOCKEState state() {
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
