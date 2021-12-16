package tegenton.card.parse.dfa.state.c.r.e.a.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.r.e.a.CREATState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class CREATEState extends CREATState {
    private static final CREATEState INSTANCE = new CREATEState();

    public static CREATEState state() {
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
            case '\0', ' ' -> Optional.of(PlayerVerb.CREATE);
            default -> Optional.empty();
        };
    }
}
