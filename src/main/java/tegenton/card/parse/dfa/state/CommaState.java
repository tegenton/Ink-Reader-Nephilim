package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Punctuation;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CommaState extends State {
    private static final CommaState INSTANCE = new CommaState();

    public static CommaState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Punctuation.COMMA);
            default -> Optional.empty();
        };
    }
}
