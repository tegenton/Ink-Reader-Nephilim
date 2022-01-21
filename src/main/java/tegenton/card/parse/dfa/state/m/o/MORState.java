package tegenton.card.parse.dfa.state.m.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.MOState;
import tegenton.card.parse.dfa.state.m.o.r.MOREState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class MORState extends MOState {
    private static final MORState instance = new MORState();

    public static MORState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> MOREState.state();
            default -> throw new IllegalStateException("Cannot transition from MORState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
