package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class IState extends State {
    private static final IState instance = new IState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> INState.state();
            default -> throw new IllegalStateException("Cannot transition from IState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
