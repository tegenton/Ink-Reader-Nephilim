package tegenton.card.parse.dfa.state.g.r.e.a.t.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.g.r.e.a.t.GREATEState;
import tegenton.card.parse.lexicon.Comparative;

import java.util.Optional;

public class GREATERState extends GREATEState {
    private static final GREATERState instance = new GREATERState();

    public static GREATERState state() {
        return instance;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<Comparative> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ',', ' ' -> Comparative.GREATER;
            default -> null;
        });
    }
}
