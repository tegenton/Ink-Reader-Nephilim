package tegenton.card.parse.dfa.state.a.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.ALState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ALLState extends ALState {
    private static final ALLState instance = new ALLState();

    public static ALLState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from ALLState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.ALL);
            default -> Optional.empty();
        };
    }
}
