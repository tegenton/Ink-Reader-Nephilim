package tegenton.card.parse.dfa.state.l.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.LOState;
import tegenton.card.parse.dfa.state.l.o.s.LOSEState;
import tegenton.card.parse.dfa.state.l.o.s.LOSTState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class LOSState extends LOState {
    private static final LOSState INSTANCE = new LOSState();

    public static LOSState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> LOSEState.state();
            case 'T' -> LOSTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'T' -> PlayerVerb.LOSE;
            default -> null;
        });
    }
}
