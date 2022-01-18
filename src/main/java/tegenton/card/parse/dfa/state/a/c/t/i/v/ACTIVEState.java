package tegenton.card.parse.dfa.state.a.c.t.i.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerAdjective;

import java.util.Optional;

public class ACTIVEState extends ACTIVState {
    private static final ACTIVEState INSTANCE = new ACTIVEState();

    public static ACTIVEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(PlayerAdjective.ACTIVE);
            default -> Optional.empty();
        };
    }
}
