package tegenton.card.parse.dfa.state.b;

import tegenton.card.parse.dfa.state.BState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.a.BANState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class BAState extends BState {
    private static final BAState INSTANCE = new BAState();

    public static BAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> BANState.state();
            default -> throw new IllegalStateException("Cannot transition from BAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
