package tegenton.card.parse.dfa.state.o.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.OTState;
import tegenton.card.parse.dfa.state.o.t.h.OTHEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class OTHState extends OTState {
    private static final OTHState INSTANCE = new OTHState();

    public static OTHState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> OTHEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
