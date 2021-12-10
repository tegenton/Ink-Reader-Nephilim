package tegenton.card.parse.dfa.state.w.h.e;

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
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from WHENState on " + c);
        }
    }

    @Override
    public Optional<Word> produce(char c) {
        if (c == '\0') {
            return Optional.of(TriggerWord.WHEN);
        }
        return Optional.empty();
    }
}
