package tegenton.card.parse.dfa.state.s.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.SEState;
import tegenton.card.parse.dfa.state.s.e.v.SEVEState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class SEVState extends SEState {
    private static final SEVState INSTANCE = new SEVState();

    public static SEVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> SEVEState.state();
            default -> throw new IllegalStateException("Cannot transition from SEVState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
