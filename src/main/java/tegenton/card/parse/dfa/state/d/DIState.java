package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.i.DIEState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.player.PlayerVerb;
import java.util.Optional;

public class DIState extends DState {
    private static final DIState INSTANCE = new DIState();

    public static DIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> DIEState.state();
            case 'S' -> new StateSequence("SCARD", PlayerVerb.DISCARD);
            case 'V' -> new StateSequence("VIDE", PlayerVerb.DIVIDE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
