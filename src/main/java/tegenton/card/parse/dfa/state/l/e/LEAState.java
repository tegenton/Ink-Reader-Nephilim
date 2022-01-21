package tegenton.card.parse.dfa.state.l.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.LEState;
import tegenton.card.parse.dfa.state.l.e.a.LEASState;
import tegenton.card.parse.dfa.state.l.e.a.LEAVState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class LEAState extends LEState {
    private static final LEAState INSTANCE = new LEAState();

    public static LEAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> LEASState.state();
            case 'V' -> LEAVState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
