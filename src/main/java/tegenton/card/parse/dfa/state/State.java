package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public abstract class State {

    public static State empty() {
        return EmptyState.state();
    }

    public abstract State transition(char c);

    public abstract Optional<Word> produce(char c);
}
