package tegenton.card.parse.dfa.state.a.t.t.a.c.k;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.t.t.a.c.ATTACKState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.e.ATTACKEDState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.e.ATTACKERState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ATTACKEState extends ATTACKState {
    private static final ATTACKEState INSTANCE = new ATTACKEState();

    public static ATTACKEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> ATTACKEDState.state();
            case 'R' -> ATTACKERState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
