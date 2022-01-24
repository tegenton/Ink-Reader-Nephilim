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
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> ZERState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
