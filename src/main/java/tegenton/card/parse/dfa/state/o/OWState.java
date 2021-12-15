package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.w.OWNState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OWState extends OState {
    private static final OWState INSTANCE = new OWState();

    public static OWState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> OWNState.state();
            default -> throw new IllegalStateException("Cannot transition from OWState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
