package tegenton.card.parse.dfa.state;

import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public abstract class State {

    public static State empty() {
        return EmptyState.state();
    }

    public abstract State transition(char c);

    public abstract Optional<? extends Word> produce(char c);

    protected State invalid(char c) {
        throw new IllegalStateException("Cannot transition from "
                + this.getClass().getSimpleName() + " on "
                + c);
    }
}
