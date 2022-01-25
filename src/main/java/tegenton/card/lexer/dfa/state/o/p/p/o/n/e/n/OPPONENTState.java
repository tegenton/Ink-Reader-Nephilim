package tegenton.card.lexer.dfa.state.o.p.p.o.n.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.OState;
import tegenton.card.lexer.dfa.state.PossessiveState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerNoun;

import java.util.Optional;

public class OPPONENTState extends OState {
    private static final OPPONENTState INSTANCE = new OPPONENTState();

    /**
     * @return Singleton instance.
     */
    public static OPPONENTState state() {
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
            case '\u2019', ',', '\0', '.', ' ' -> PlayerNoun.OPPONENT;
            default -> null;
        });
    }
}
