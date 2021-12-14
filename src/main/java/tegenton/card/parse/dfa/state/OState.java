package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.o.OFState;
import tegenton.card.parse.dfa.state.o.ONState;
import tegenton.card.parse.dfa.state.o.ORState;
import tegenton.card.parse.dfa.state.o.OTState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OState extends State {
    private static final OState instance = new OState();

    public static OState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'F' -> OFState.state();
            case 'N' -> ONState.state();
            case 'R' -> ORState.state();
            case 'T' -> OTState.state();
            default -> throw new IllegalStateException("Cannot transition from OState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
