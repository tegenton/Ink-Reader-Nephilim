package tegenton.card.parse.dfa.state.n.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.n.NIState;
import tegenton.card.parse.dfa.state.n.i.n.NINEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class NINState extends NIState {
    private static final NINState INSTANCE = new NINState();

    public static NINState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> NINEState.state();
            default -> throw new IllegalStateException("Cannot transition from NINState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
