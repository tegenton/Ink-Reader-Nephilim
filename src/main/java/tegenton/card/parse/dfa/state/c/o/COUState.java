package tegenton.card.parse.dfa.state.c.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.COState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class COUState extends COState {
    private static final COUState INSTANCE = new COUState();

    public static COUState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> new StateSequence("LD", PlayerVerb.COULD);
            case 'N' -> new StateSequence("NTER", PlayerVerb.COUNTER);
            default -> throw new IllegalStateException(
                    "Cannot transition from COUState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
