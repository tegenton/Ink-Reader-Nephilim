package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class DIState extends DState {
    private static final DIState INSTANCE = new DIState();

    public static DIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> new StateSequence("SCARD", PlayerVerb.DISCARD);
            case 'V' -> new StateSequence("VIDE", PlayerVerb.DIVIDE);
            default -> throw new IllegalStateException("Cannot transition from DIState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
