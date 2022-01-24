package tegenton.card.parse.dfa.state.u.p.k.e.e;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.u.UPState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Step;

import java.util.Optional;

public class UPKEEPState extends UPState {
    private static final UPKEEPState INSTANCE = new UPKEEPState();

    /**
     * @return Singleton instance.
     */
    public static UPKEEPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', ',', '\0', '.', ' ' -> Step.UPKEEP;
            default -> null;
        });
    }
}
