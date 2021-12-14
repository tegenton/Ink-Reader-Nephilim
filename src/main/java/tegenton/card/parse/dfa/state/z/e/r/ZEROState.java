package tegenton.card.parse.dfa.state.z.e.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.z.e.ZERState;
import tegenton.card.parse.lexicon.EnglishNumber;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ZEROState extends ZERState {
    private static final ZEROState INSTANCE = new ZEROState();

    public static ZEROState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from ZEROState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.ZERO);
            default -> Optional.empty();
        };
    }
}
