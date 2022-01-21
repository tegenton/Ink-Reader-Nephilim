package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.i.EIGState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EIState extends EState {
    private static final EIState INSTANCE = new EIState();

    public static EIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'G' -> EIGState.state();
            default -> throw new IllegalStateException("Cannot transition from EIState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
