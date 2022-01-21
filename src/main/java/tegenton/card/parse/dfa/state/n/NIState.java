package tegenton.card.parse.dfa.state.n;

import tegenton.card.parse.dfa.state.NState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.n.i.NINState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class NIState extends NState {
    private static final NIState INSTANCE = new NIState();

    public static NIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> NINState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
