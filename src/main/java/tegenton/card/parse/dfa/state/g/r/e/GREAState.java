package tegenton.card.parse.dfa.state.g.r.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.e.a.GREATState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class GREAState extends State {
    private static final GREAState instance = new GREAState();

    public static GREAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> GREATState.state();
            default -> throw new IllegalStateException("Cannot transition from GREAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
