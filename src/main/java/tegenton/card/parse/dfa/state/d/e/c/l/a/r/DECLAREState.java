package tegenton.card.parse.dfa.state.d.e.c.l.a.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DECLAREState extends DEState {
    private static final DECLAREState INSTANCE = new DECLAREState();

    public static DECLAREState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.DECLARE;
            default -> null;
        });
    }
}
