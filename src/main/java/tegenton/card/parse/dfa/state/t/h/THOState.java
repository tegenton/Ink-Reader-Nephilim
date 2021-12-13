package tegenton.card.parse.dfa.state.t.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.THState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THOState extends THState {
    private static final THOState instance = new THOState();

    public static THOState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THOState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
