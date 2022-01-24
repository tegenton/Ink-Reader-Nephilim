package tegenton.card.parse.dfa.state.e.i.g;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.i.EIGState;
import tegenton.card.parse.dfa.state.e.i.g.h.EIGHTState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class EIGHState extends EIGState {
    private static final EIGHState INSTANCE = new EIGHState();

    public static EIGHState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> EIGHTState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
