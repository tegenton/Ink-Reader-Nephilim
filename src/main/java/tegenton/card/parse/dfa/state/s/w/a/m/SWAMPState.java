package tegenton.card.parse.dfa.state.s.w.a.m;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class SWAMPState extends SState {
    private static final SWAMPState INSTANCE = new SWAMPState();

    /**
     * @return Singleton instance.
     */
    public static SWAMPState state() {
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
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', 'W', '\0', '.', ' ' -> LandType.SWAMP;
            default -> null;
        });
    }
}
