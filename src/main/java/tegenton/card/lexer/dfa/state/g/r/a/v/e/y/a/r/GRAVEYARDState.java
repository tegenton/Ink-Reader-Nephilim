package tegenton.card.lexer.dfa.state.g.r.a.v.e.y.a.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.g.GRState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;

import java.util.Optional;

public class GRAVEYARDState extends GRState {
    private static final GRAVEYARDState INSTANCE = new GRAVEYARDState();

    /**
     * @return Singleton instance.
     */
    public static GRAVEYARDState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\u201D', '\n', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\u201D', '\n', '\0', '.', ' ' -> Zone.GRAVEYARD;
            default -> null;
        });
    }
}
