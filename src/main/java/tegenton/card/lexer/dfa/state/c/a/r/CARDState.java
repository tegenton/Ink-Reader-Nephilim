package tegenton.card.lexer.dfa.state.c.a.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.c.a.CARState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;

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
