package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.o.ONState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class OState extends State {
    private static final OState instance = new OState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> ONState.state();
            default -> throw new IllegalStateException("Cannot transition from OState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}