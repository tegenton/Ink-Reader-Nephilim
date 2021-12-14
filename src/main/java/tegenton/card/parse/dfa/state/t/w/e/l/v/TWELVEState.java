package tegenton.card.parse.dfa.state.t.w.e.l.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TWELVEState extends State {
    private static final TWELVEState INSTANCE = new TWELVEState();

    public static TWELVEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from TWELVEState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', '0' -> Optional.of(EnglishNumber.TWELVE);
            default -> Optional.empty();
        };
    }
}
