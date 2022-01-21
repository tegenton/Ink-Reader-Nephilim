package tegenton.card.parse.dfa.state.t.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.THState;
import tegenton.card.parse.dfa.state.t.h.a.THANState;
import tegenton.card.parse.dfa.state.t.h.a.THATState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THAState extends THState {
    private static final THAState INSTANCE = new THAState();

    public static THAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> THATState.state();
            case 'N' -> THANState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
