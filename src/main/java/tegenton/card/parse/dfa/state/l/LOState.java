package tegenton.card.parse.dfa.state.l;

import tegenton.card.parse.dfa.state.LState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.player.PlayerVerb;
import java.util.Optional;

public class LOState extends LState {
    private static final LOState INSTANCE = new LOState();

    public static LOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'O' -> new StateSequence("OK", PlayerVerb.LOOK);
            case 'S' -> new StateSequence("SE", PlayerVerb.LOSE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
