package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ORState extends OState {
    private static final ORState instance = new ORState();

    public static ORState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from ORState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Conjunction.OR);
            default -> Optional.empty();
        };
    }
}
