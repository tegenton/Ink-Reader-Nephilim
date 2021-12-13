package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THESState extends THEState {
    private static final THESState instance = new THESState();

    public static THESState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> THESEState.state();
            default -> throw new IllegalStateException("Cannot transition from THESState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
