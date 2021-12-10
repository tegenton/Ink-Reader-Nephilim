package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.INGState;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class INState extends State {
    private static final INState instance = new INState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'G' -> INGState.state();
            default -> throw new IllegalStateException("Cannot transition from INState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        if (c == '\0') {
            return Optional.of(Preposition.IN);
        }
        return Optional.empty();
    }
}
