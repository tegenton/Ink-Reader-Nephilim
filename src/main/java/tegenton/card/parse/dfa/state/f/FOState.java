package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.o.FOUState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FOState extends FState {
    private static final FOState instance = new FOState();

    public static FOState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'U' -> FOUState.state();
            default -> throw new IllegalStateException("Cannot transition from FOState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
