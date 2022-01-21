package tegenton.card.parse.dfa.state.i.n.s.t.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.s.t.INSTAState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.n.INSTANCState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.n.INSTANTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class INSTANState extends INSTAState {
    private static final INSTANState INSTANCE = new INSTANState();

    public static INSTANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> INSTANCState.state();
            case 'T' -> INSTANTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
