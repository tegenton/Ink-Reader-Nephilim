package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class THENState extends THEState {
    private static final THENState instance = new THENState();

    public static THENState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THENState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case ' ', '\0' -> Optional.of(Conjunction.THEN);
            default -> Optional.empty();
        };
    }
}
