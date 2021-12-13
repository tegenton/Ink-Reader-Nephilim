package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.n.NOState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class NState extends State {
    private static final NState instance = new NState();

    public static NState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> NOState.state();
            default -> throw new IllegalStateException("Cannot transition from NState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
