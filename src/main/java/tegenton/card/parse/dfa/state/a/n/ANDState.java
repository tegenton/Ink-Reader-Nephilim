package tegenton.card.parse.dfa.state.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ANDState extends ANState {
    private static final ANDState instance = new ANDState();

    public static ANDState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from ANDState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Conjunction.AND);
            default -> Optional.empty();
        };
    }
}
