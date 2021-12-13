package tegenton.card.parse.dfa.state.c.a.r;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.a.CARState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.object.ObjectNoun;
import java.util.Optional;

public class CARDState extends CARState {
    private static final CARDState instance = new CARDState();

    public static CARDState state() {
        return instance;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            default -> throw new IllegalStateException("Cannot transition from CARDState on " + c);
        };
    }

    @Override
    public Optional<ObjectNoun> produce(char c) {
        return switch (c) {
            case 'S' -> Optional.of(ObjectNoun.CARD);
            default -> Optional.empty();
        };
    }
}
