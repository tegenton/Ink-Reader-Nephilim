package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.dfa.state.t.h.e.s.THESEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THESState extends THEState {
    private static final THESState INSTANCE = new THESState();

    public static THESState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> THESEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
