package tegenton.card.parse.dfa.state.o.p.p.o.n.e.n;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun;

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
