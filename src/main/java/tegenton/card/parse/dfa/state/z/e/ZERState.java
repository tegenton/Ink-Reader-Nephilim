package tegenton.card.parse.dfa.state.z.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.z.ZEState;
import tegenton.card.parse.dfa.state.z.e.r.ZEROState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ZERState extends ZEState {
    private static final ZERState INSTANCE = new ZERState();

    public static ZERState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> ZEROState.state();
            default -> throw new IllegalStateException("Cannot transition from ZERState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
