package tegenton.card.lexer.dfa.state.m.o.u.n.t.a.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.WState;
import tegenton.card.lexer.dfa.state.m.MOState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.LandType;

import java.util.Optional;

public class MOUNTAINState extends MOState {
    private static final MOUNTAINState INSTANCE = new MOUNTAINState();

    /**
     * @return Singleton instance.
     */
    public static MOUNTAINState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case 'W' -> WState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', 'W', '\0', ' ' -> LandType.MOUNTAIN;
            default -> null;
        });
    }
}
