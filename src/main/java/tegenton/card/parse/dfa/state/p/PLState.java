package tegenton.card.parse.dfa.state.p;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class PLState extends State {
    private static final PLState instance = new PLState();

    public static PLState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from PLState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
