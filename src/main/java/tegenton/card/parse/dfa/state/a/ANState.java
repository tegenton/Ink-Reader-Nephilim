package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.n.ANDState;
import tegenton.card.parse.dfa.state.a.n.ANYState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.Zone;
import java.util.Optional;

public class ANState extends AState {
    private static final ANState INSTANCE = new ANState();

    public static ANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> ANDState.state();
            case 'T' -> new StateSequence("TE", Zone.ANTE);
            case 'O' -> OState.state();
            case 'Y' -> ANYState.state();
            default -> throw new IllegalStateException("Cannot transition from ANState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case 'O', '\0', ' ' -> Optional.of(Determiner.AN);
            default -> Optional.empty();
        };
    }
}
