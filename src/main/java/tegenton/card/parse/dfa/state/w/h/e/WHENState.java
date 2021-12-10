package tegenton.card.parse.dfa.state.w.h.e;

import tegenton.card.parse.dfa.state.SpaceState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.TriggerWord;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WHENState extends State {
    private static final WHENState instance = new WHENState();

    public static State state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ' ' -> SpaceState.state();
            default -> throw new IllegalStateException("Cannot transition from WHENState on " + c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(TriggerWord.WHEN);
            default -> Optional.empty();
        };
    }
}
