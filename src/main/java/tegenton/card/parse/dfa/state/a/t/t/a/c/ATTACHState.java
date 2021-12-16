package tegenton.card.parse.dfa.state.a.t.t.a.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.t.t.a.ATTACState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import java.util.Optional;

public class ATTACHState extends ATTACState {
    private static final ATTACHState INSTANCE = new ATTACHState();

    public static ATTACHState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(PlayerVerb.ATTACH);
            default -> Optional.empty();
        };
    }
}
