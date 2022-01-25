package tegenton.card.lexer.dfa.state.a.c.t.i.v;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerAdjective;

import java.util.Optional;

public class ACTIVEState extends ACTIVState {
    private static final ACTIVEState INSTANCE = new ACTIVEState();

    /**
     * @return Singleton instance.
     */
    public static ACTIVEState state() {
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
        return switch (c) {
            case '\0', ' ' -> Optional.of(PlayerAdjective.ACTIVE);
            default -> Optional.empty();
        };
    }
}
