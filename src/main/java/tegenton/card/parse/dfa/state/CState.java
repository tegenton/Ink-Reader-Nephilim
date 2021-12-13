package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CState extends State {
    private static final CState instance = new CState();

    public static CState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> CAState.state();
            default -> throw new IllegalStateException("Cannot transition from CState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
