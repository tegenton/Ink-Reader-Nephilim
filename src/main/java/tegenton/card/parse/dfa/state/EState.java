package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.e.EAState;
import tegenton.card.parse.dfa.state.e.ERState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class EState extends State {
    private static final EState instance = new EState();

    public static EState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> EAState.state();
            case 'R' -> ERState.state();
            default -> throw new IllegalStateException("Cannot transition from EState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
