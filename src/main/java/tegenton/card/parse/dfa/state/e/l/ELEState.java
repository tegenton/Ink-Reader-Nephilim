package tegenton.card.parse.dfa.state.e.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.ELState;
import tegenton.card.parse.dfa.state.e.l.e.ELEVState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ELEState extends ELState {
    private static final ELEState INSTANCE = new ELEState();

    public static ELEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'V' -> ELEVState.state();
            default -> throw new IllegalStateException("Cannot transition from ELEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}