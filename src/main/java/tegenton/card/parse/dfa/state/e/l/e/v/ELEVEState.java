package tegenton.card.parse.dfa.state.e.l.e.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.l.e.ELEVState;
import tegenton.card.parse.dfa.state.e.l.e.v.e.ELEVENState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ELEVEState extends ELEVState {
    private static final ELEVEState INSTANCE = new ELEVEState();

    public static ELEVEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> ELEVENState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
