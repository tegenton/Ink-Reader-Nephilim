package tegenton.card.parse.dfa.state.f.l;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FLYState extends State {
    private static final FLYState instance = new FLYState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> IState.state();
            default -> throw new IllegalStateException("Cannot transition from FLYState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        if (c == 'I') {
            return Optional.of(Keyword.FLY);
        }
        return Optional.empty();
    }
}
