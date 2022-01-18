package tegenton.card.parse.dfa.state.a.c.t.i.v.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class ACTIVATEState extends ACTIVState {
    private static final ACTIVATEState INSTANCE = new ACTIVATEState();

    public static ACTIVATEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(PlayerVerb.ACTIVATE);
            default -> Optional.empty();
        };
    }
}
