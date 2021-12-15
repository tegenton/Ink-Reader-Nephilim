package tegenton.card.parse.dfa.state.a.t.t.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.t.t.ATTAState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.ATTACHState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.ATTACKState;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class ATTACState extends ATTAState {
    private static final ATTACState INSTANCE = new ATTACState();

    public static ATTACState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'H' -> ATTACHState.state();
            case 'K' -> ATTACKState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
