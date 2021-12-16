package tegenton.card.parse.dfa.state.c.a.r;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.a.CARState;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import java.util.Optional;

public final class CARDState extends CARState {
    private static final CARDState INSTANCE = new CARDState();

    public static CARDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<ObjectNoun> produce(final char c) {
        return switch (c) {
            case 'S', '\0', ' ' -> Optional.of(ObjectNoun.CARD);
            default -> Optional.empty();
        };
    }
}
