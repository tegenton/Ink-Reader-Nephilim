package tegenton.card.parse.dfa.state.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.EAState;
import tegenton.card.parse.dfa.state.e.a.c.EACHState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EACState extends EAState {
    private static final EACState instance = new EACState();

    public static EACState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'H' -> EACHState.state();
            default -> throw new IllegalStateException("Cannot transition from EACState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
