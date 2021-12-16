package tegenton.card.parse.dfa.state.c.r.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.r.CREState;
import tegenton.card.parse.dfa.state.c.r.e.a.CREATState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class CREAState extends CREState {
    private static final CREAState INSTANCE = new CREAState();

    public static CREAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> CREATState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
