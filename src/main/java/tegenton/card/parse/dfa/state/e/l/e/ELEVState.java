package tegenton.card.parse.dfa.state.e.l.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.ELEState;
import tegenton.card.parse.dfa.state.e.l.e.v.ELEVEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ELEVState extends ELEState {
    private static final ELEVState INSTANCE = new ELEVState();

    public static ELEVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ELEVEState.state();
            default -> throw new IllegalStateException("Cannot transition from ELEVState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}