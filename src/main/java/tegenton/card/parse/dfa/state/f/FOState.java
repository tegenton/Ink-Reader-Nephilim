package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.o.FORState;
import tegenton.card.parse.dfa.state.f.o.FOUState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FOState extends FState {
    private static final FOState INSTANCE = new FOState();

    public static FOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> FORState.state();
            case 'U' -> FOUState.state();
            default -> throw new IllegalStateException("Cannot transition from FOState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
