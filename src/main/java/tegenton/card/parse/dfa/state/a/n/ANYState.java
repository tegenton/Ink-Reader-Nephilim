package tegenton.card.parse.dfa.state.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ANYState extends State {
    private static final ANYState instance = new ANYState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        throw new IllegalStateException("Cannot transition from ANYState on " + c);
    }

    @Override
    public Optional<Word> produce(char c) {
        if (c == '\0') {
            return Optional.of(Determiner.ANY);
        }
        return Optional.empty();
    }
}
