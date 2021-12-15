package tegenton.card.parse.dfa.state.c;

import tegenton.card.parse.dfa.state.CState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.a.CARState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.player.PlayerVerb;
import java.util.Optional;

public class CAState extends CState {
    private static final CAState instance = new CAState();

    public static CAState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> CARState.state();
            case 'S' -> new StateSequence("ST", PlayerVerb.CAST);
            default -> throw new IllegalStateException("Cannot transition from CAState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
