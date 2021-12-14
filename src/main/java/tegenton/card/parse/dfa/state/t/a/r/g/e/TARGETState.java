package tegenton.card.parse.dfa.state.t.a.r.g.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.a.r.g.TARGEState;
import tegenton.card.parse.lexicon.Determiner;
import java.util.Optional;

public final class TARGETState extends TARGEState {
    private static final TARGETState INSTANCE = new TARGETState();

    public static TARGETState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException("Cannot transition from EmptyState on " + c);
        };
    }

    @Override
    public Optional<Determiner> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Determiner.TARGET);
            default -> Optional.empty();
        };
    }
}
