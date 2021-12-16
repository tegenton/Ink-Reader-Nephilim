package tegenton.card.parse.dfa.state.t.w;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TWState;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class TWOState extends TWState {
    private static final TWOState instance = new TWOState();

    public static TWOState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException(
                    "Cannot transition from TWOState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.TWO);
            default -> Optional.empty();
        };
    }
}
