package tegenton.card.parse.dfa.state.c.r.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.r.e.CREAState;
import tegenton.card.parse.dfa.state.c.r.e.a.t.CREATEState;
import tegenton.card.parse.dfa.state.c.r.e.a.t.u.r.CREATUREState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CREATState extends CREAState {

    private static final CREATState INSTANCE = new CREATState();

    public static CREATState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> CREATEState.state();
            case 'U' -> new InfixSubstring("UR", 'E', CREATUREState::state);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
