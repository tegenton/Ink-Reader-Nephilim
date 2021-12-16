package tegenton.card.parse.dfa.state.d.r.a;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.r.DRAState;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public final class DRAWState extends DRAState {
    private static final DRAWState INSTANCE = new DRAWState();

    public static DRAWState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case ' ' -> SymbolState.state(c);
            default -> throw new IllegalStateException(
                    "Cannot transition from DRAWState on " + c);
        };
    }

    @Override
    public Optional<PlayerVerb> produce(final char c) {
        return switch (c) {
            case 'S', '\0', ' ' -> Optional.of(PlayerVerb.DRAW);
            default -> Optional.empty();
        };
    }
}
