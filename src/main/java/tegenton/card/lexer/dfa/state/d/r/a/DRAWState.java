package tegenton.card.lexer.dfa.state.d.r.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.d.r.DRAState;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public final class DRAWState extends DRAState {
    private static final DRAWState INSTANCE = new DRAWState();

    /**
     * @return Singleton instance.
     */
    public static DRAWState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PlayerVerb> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> PlayerVerb.DRAW;
            default -> null;
        });
    }
}
