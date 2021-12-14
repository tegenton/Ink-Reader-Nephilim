package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.TriggerWord;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ATState extends AState {
    private static final ATState INSTANCE = new ATState();

    public static ATState state() {
        return INSTANCE;
    }

    public State transition(final char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from AState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(TriggerWord.AT);
            default -> Optional.empty();
        };
    }
}
