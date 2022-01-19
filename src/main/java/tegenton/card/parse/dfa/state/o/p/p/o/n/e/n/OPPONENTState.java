package tegenton.card.parse.dfa.state.o.p.p.o.n.e.n;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerNoun;

import java.util.Optional;

public class OPPONENTState extends OState {
    private static final OPPONENTState INSTANCE = new OPPONENTState();

    public static OPPONENTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\u2019', ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\u2019', ',', '\0', ' ' -> PlayerNoun.OPPONENT;
            default -> null;
        });
    }
}
