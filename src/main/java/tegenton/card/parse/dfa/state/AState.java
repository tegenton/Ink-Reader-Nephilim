package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class AState extends State {
    private static final AState instance = new AState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from AState on " + c);
        }
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0' -> Optional.of(Determiner.A);
            default -> Optional.empty();
        };
    }
}
