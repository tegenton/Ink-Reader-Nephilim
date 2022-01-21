package tegenton.card.parse.dfa.state.g.r.e.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.r.e.a.GREATState;
import tegenton.card.parse.dfa.state.g.r.e.a.t.e.GREATERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class GREATEState extends GREATState {
    private static final GREATEState INSTANCE = new GREATEState();

    public static GREATEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> GREATERState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
