package tegenton.card.parse.dfa.state.f.i.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.i.FIVState;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class FIVEState extends FIVState {
    private static final FIVEState instance = new FIVEState();

    public static FIVEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException(
                    "Cannot transition from FIVEState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.FIVE);
            default -> Optional.empty();
        };
    }
}
