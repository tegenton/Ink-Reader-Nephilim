package tegenton.card.parse.dfa.state.p.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.dfa.state.p.l.a.PLAYState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class PLAState extends PLState {
    private static final PLAState instance = new PLAState();

    public static PLAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'Y' -> PLAYState.state();
            default -> throw new IllegalStateException("Cannot transition from PLAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
