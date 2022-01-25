package tegenton.card.lexer.dfa.state.c.r.e.a.t.u.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.PossessiveState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.c.r.e.a.CREATState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CardType;

import java.util.Optional;

public class CREATUREState extends CREATState {
    private static final CREATUREState INSTANCE = new CREATUREState();

    /**
     * @return Singleton instance.
     */
    public static CREATUREState state() {
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
            case ',', '\n', '.', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', ',', '\n', '.', '\0', ' ' -> CardType.CREATURE;
            default -> null;
        });
    }
}
