package tegenton.card.parse.dfa.state.m;

import tegenton.card.parse.dfa.state.MState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.o.MORState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class MOState extends MState {
    private static final MOState instance = new MOState();

    public static MOState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> MORState.state();
            default -> throw new IllegalStateException("Cannot transition from MOState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
