package tegenton.card.parse.dfa.state.r.e.g.e.n.e.r.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REGENERATEState extends REState {
    private static final REGENERATEState INSTANCE = new REGENERATEState();

    public static REGENERATEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.REGENERATE;
            default -> null;
        });
    }
}
