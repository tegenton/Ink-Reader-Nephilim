package tegenton.card.parse.dfa.state.d.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DIState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.object.ObjectVerb;
import java.util.Optional;

public class DIEState extends DIState {
    private static final DIEState INSTANCE = new DIEState();

    public static DIEState state() {
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
            case '\0', ' ' -> Optional.of(ObjectVerb.DIE);
            default -> Optional.empty();
        };
    }
}
