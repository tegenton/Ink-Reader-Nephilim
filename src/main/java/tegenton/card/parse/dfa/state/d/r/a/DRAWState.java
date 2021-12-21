package tegenton.card.parse.dfa.state.d.r.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.r.DRAState;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public final class DRAWState extends DRAState {
    private static final DRAWState INSTANCE = new DRAWState();

    public static DRAWState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<PlayerVerb> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> PlayerVerb.DRAW;
            default -> null;
        });
    }
}
