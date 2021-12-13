package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.t.OTHState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OTState extends OState {
    private static final OTState instance = new OTState();

    public static OTState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'H' -> OTHState.state();
            default -> throw new IllegalStateException("Cannot transition from OTState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
