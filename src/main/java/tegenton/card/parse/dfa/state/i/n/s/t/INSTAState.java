package tegenton.card.parse.dfa.state.i.n.s.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.s.INSTState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.INSTANState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INSTAState extends INSTState {
    private static final INSTAState INSTANCE = new INSTAState();

    public static INSTAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> INSTANState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
