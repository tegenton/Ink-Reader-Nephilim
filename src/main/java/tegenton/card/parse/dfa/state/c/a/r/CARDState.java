package tegenton.card.parse.dfa.state.c.a.r;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.a.CARState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;

import java.util.Optional;

public final class CARDState extends CARState {
    private static final CARDState INSTANCE = new CARDState();

    /**
     * @return Singleton instance.
     */
    public static CARDState state() {
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
            case 'S', ',', '\0', '.', ' ' -> ObjectNoun.CARD;
            default -> null;
        });
    }
}
