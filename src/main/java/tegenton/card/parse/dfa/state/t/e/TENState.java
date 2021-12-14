package tegenton.card.parse.dfa.state.t.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TEState;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TENState extends TEState {
    private static final TENState INSTANCE = new TENState();

    public static TENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from TENState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.TEN);
            default -> Optional.empty();
        };
    }
}
