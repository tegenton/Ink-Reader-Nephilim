package tegenton.card.parse.dfa.state.l.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.l.e.LEAState;
import tegenton.card.parse.dfa.state.l.e.a.v.LEAVEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class LEAVState extends LEAState {
    private static final LEAVState INSTANCE = new LEAVState();

    public static LEAVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> LEAVEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return super.produce(c);
    }
}
