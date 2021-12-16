package tegenton.card.parse.dfa.state.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.e.SEVState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class SEState extends SState {
    private static final SEState instance = new SEState();

    public static SEState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("ARCH", PlayerVerb.SEARCH);
            case 'V' -> SEVState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
