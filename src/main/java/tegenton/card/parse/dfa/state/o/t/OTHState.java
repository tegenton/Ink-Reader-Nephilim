package tegenton.card.parse.dfa.state.o.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.OTState;
import tegenton.card.parse.dfa.state.o.t.h.OTHEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OTHState extends OTState {
    private static final OTHState instance = new OTHState();

    public static OTHState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> OTHEState.state();
            default -> throw new IllegalStateException("Cannot transition from OTHState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
