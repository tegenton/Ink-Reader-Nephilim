package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.ELEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ELState extends EState {
    private static final ELState INSTANCE = new ELState();

    public static ELState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ELEState.state();
            default -> throw new IllegalStateException("Cannot transition from ELState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
