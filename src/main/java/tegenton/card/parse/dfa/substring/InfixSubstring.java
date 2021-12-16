package tegenton.card.parse.dfa.substring;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;
import java.util.function.Supplier;

public class InfixSubstring extends Substring {
    private final char valid;
    private final Supplier<State> out;

    public InfixSubstring(String text, char valid, Supplier<State> out) {
        super(text.toCharArray());
        this.valid = valid;
        this.out = out;
    }

    public State transition(char c) {
        if (completed() && c == valid) {
            return out.get();
        } else {
            return super.transition(c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
