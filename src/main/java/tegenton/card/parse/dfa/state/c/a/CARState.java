package tegenton.card.parse.dfa.state.c.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.dfa.state.c.a.r.CARDState;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CARState extends CAState {
    private static final CARState INSTANCE = new CARState();

    public static CARState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> CARDState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
