package tegenton.card.parse.dfa.state.m.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.MAState;
import tegenton.card.parse.dfa.state.m.a.n.MANAState;
import tegenton.card.parse.dfa.state.m.a.n.MANYState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class MANState extends MAState {
    private static final MANState INSTANCE = new MANState();

    public static MANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> MANAState.state();
            case 'Y' -> MANYState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
