package tegenton.card.parse.dfa.state.c.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.CRState;
import tegenton.card.parse.dfa.state.c.r.e.CREAState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CREState extends CRState {
    private static final CREState INSTANCE = new CREState();

    public static CREState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> CREAState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
