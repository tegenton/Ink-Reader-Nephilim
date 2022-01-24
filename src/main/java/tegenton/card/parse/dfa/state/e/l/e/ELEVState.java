package tegenton.card.parse.dfa.state.e.l.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.ELEState;
import tegenton.card.parse.dfa.state.e.l.e.v.ELEVEState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ELEVState extends ELEState {
    private static final ELEVState INSTANCE = new ELEVState();

    public static ELEVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ELEVEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
