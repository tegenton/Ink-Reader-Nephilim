package tegenton.card.parse.dfa.state.s.p.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.p.SPEState;
import tegenton.card.parse.dfa.state.s.p.e.n.SPENDState;
import tegenton.card.parse.dfa.state.s.p.e.n.SPENTState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SPENState extends SPEState {
    private static final SPENState INSTANCE = new SPENState();

    public static SPENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> SPENDState.state();
            case 'T' -> SPENTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'T' -> PlayerVerb.SPEND;
            default -> null;
        });
    }
}
