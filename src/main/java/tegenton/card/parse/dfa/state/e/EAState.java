package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.a.EACState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EAState extends EState {
    private static final EAState instance = new EAState();

    public static EAState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> EACState.state();
            default -> throw new IllegalStateException("Cannot transition from EAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
