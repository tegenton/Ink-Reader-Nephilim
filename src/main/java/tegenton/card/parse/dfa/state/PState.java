package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.dfa.state.p.PRState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerVerb;
import java.util.Optional;

public class PState extends State {
    private static final PState INSTANCE = new PState();

    public static PState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("AY", PlayerVerb.PAY);
            case 'L' -> PLState.state();
            case 'R' -> PRState.state();
            case 'U' -> new StateSequence("UT", PlayerVerb.PUT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
