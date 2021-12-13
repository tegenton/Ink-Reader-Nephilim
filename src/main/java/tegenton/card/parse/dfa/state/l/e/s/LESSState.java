package tegenton.card.parse.dfa.state.l.e.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.LESState;
import tegenton.card.parse.lexicon.Comparative;
import java.util.Optional;

public class LESSState extends LESState {
    private static final LESSState instance = new LESSState();

    public static LESSState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from LESSState on " + c);
        }
    }

    @Override
    public Optional<Comparative> produce(char c) {
        if (c == '\0') {
            return Optional.of(Comparative.LESS);
        }
        return Optional.empty();
    }
}
