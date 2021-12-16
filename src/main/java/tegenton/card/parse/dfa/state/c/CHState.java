package tegenton.card.parse.dfa.state.c;

import tegenton.card.parse.dfa.state.CState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class CHState extends CState {
    private static final CHState INSTANCE = new CHState();

    public static CHState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("ANGE", PlayerVerb.CHANGE);
            case 'O' -> new StateSequence("OOSE", PlayerVerb.CHOOSE);
            default -> throw new IllegalStateException(
                    "Cannot transition from CHState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return super.produce(c);
    }
}
