package tegenton.card.parse.dfa.state.t.a.r.g;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.a.r.TARGState;
import tegenton.card.parse.dfa.state.t.a.r.g.e.TARGETState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class TARGEState extends TARGState {
    private static final TARGEState INSTANCE = new TARGEState();

    public static TARGEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> TARGETState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
