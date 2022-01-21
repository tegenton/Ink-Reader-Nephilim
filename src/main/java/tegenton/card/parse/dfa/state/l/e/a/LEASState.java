package tegenton.card.parse.dfa.state.l.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.LEAState;
import tegenton.card.parse.dfa.state.l.e.a.s.LEASTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class LEASState extends LEAState {
    private static final LEASState INSTANCE = new LEASState();

    public static LEASState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'T' -> LEASTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return super.produce(c);
    }
}
