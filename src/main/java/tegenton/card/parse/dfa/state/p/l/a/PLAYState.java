package tegenton.card.parse.dfa.state.p.l.a;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.l.PLAState;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class PLAYState extends PLAState {
    private static final PLAYState INSTANCE = new PLAYState();

    public static PLAYState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> EState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<PlayerVerb> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', '\0', ' ' -> PlayerVerb.PLAY;
            default -> null;
        });
    }
}
