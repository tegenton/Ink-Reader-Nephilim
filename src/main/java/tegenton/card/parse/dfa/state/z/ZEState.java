package tegenton.card.parse.dfa.state.z;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.ZState;
import tegenton.card.parse.dfa.state.z.e.ZERState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ZEState extends ZState {
    private static final ZEState INSTANCE = new ZEState();

    public static ZEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> ZERState.state();
            default -> throw new IllegalStateException("Cannot transition from ZEState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}