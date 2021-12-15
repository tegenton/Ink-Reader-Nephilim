package tegenton.card.parse.dfa.state.e.l.e.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.e.ELEVState;
import tegenton.card.parse.dfa.state.e.l.e.v.e.ELEVENState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ELEVEState extends ELEVState {
    private static final ELEVEState INSTANCE = new ELEVEState();

    public static ELEVEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> ELEVENState.state();
            default -> throw new IllegalStateException("Cannot transition from ELEVEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}