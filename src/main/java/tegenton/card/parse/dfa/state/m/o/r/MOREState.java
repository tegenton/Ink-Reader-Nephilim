package tegenton.card.parse.dfa.state.m.o.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.o.MORState;
import tegenton.card.parse.lexicon.Comparative;
import java.util.Optional;

public class MOREState extends MORState {
    private static final MOREState instance = new MOREState();

    public static MOREState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from MOREState on " + c);
        }
    }

    @Override
    public Optional<Comparative> produce(char c) {
        if (c == '\0') {
            return Optional.of(Comparative.MORE);
        }
        return Optional.empty();
    }
}
