package tegenton.card.parse.dfa.state.d.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DRState;
import tegenton.card.parse.dfa.state.d.r.a.DRAWState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class DRAState extends DRState {
    private static final DRAState instance = new DRAState();

    public static DRAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'W' -> DRAWState.state();
            default -> throw new IllegalStateException("Cannot transition from DRAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
