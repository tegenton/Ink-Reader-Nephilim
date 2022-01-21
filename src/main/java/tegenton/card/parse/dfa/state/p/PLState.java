package tegenton.card.parse.dfa.state.p;

import tegenton.card.parse.dfa.state.PState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.l.PLAState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class PLState extends PState {
    private static final PLState INSTANCE = new PLState();

    public static PLState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> PLAState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
