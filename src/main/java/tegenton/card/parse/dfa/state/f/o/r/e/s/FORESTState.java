package tegenton.card.parse.dfa.state.f.o.r.e.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.dfa.state.f.o.FORState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class FORESTState extends FORState {
    private static final FORESTState INSTANCE = new FORESTState();

    /**
     * @return Singleton instance.
     */
    public static FORESTState state() {
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
            case 'S', 'W', '\0', ' ' -> LandType.FOREST;
            default -> null;
        });
    }
}
