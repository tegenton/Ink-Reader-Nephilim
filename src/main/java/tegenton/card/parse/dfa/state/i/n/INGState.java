package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class INGState extends State {
    private static final INGState instance = new INGState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from INGState on " + c);
        }
    }

    @Override
    public Optional<Word> produce(char c) {
        if (c == '\0') {
            return Optional.of(Morpheme.ING);
        }
        return Optional.empty();
    }
}
