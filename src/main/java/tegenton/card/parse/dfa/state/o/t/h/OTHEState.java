package tegenton.card.parse.dfa.state.o.t.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.t.OTHState;
import tegenton.card.parse.dfa.state.o.t.h.e.OTHERState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OTHEState extends OTHState {
    private static final OTHEState instance = new OTHEState();

    public static OTHEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> OTHERState.state();
            default -> throw new IllegalStateException("Cannot transition from OTHEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
