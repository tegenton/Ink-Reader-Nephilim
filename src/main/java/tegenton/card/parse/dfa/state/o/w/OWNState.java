package tegenton.card.parse.dfa.state.o.w;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.o.OWState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import java.util.Optional;

public class OWNState extends OWState {
    private static final OWNState INSTANCE = new OWNState();

    public static OWNState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> EState.state();
            default -> throw new IllegalStateException(
                    "Cannot transition from OWNState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case 'E', '\0', ' ' -> Optional.of(PlayerVerb.OWN);
            default -> Optional.empty();
        };
    }
}
