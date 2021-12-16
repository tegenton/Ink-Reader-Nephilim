package tegenton.card.parse.dfa.state.t.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.TAState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;
import java.util.Optional;

public class TAPState extends TAState {
    private static final TAPState INSTANCE = new TAPState();

    public static TAPState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(ObjectVerb.TAP);
            default -> Optional.empty();
        };
    }
}
