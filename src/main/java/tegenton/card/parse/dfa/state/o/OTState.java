package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.t.OTHState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class OTState extends OState {
    private static final OTState INSTANCE = new OTState();

    public static OTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> OTHState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
