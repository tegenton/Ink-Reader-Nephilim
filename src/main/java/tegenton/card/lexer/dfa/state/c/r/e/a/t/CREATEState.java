package tegenton.card.lexer.dfa.state.c.r.e.a.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.c.r.e.a.CREATState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class CREATEState extends CREATState {
    private static final CREATEState INSTANCE = new CREATEState();

    /**
     * @return Singleton instance.
     */
    public static CREATEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
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
            case '\0', ' ' -> PlayerVerb.CREATE;
            default -> null;
        });
    }
}