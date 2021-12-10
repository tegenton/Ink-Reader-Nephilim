package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.n.ONEState;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ONState extends State {
    private static final ONState instance = new ONState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ONEState.state();
            default -> throw new IllegalStateException("Cannot transition from ONEState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0' -> Optional.of(Preposition.ON);
            default -> Optional.empty();
        };
    }
}
