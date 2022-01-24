package tegenton.card.parse.dfa.state.a.r.t.i.f.a.c;

import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ARState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class ARTIFACTState extends ARState {
    private static final ARTIFACTState INSTANCE = new ARTIFACTState();

    /**
     * @return Singleton instance.
     */
    public static ARTIFACTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\u2019' -> PossessiveState.state();
            case ',', '\n', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', ',', '\n', '\0', '.', ' ' -> CardType.ARTIFACT;
            default -> null;
        });
    }
}
