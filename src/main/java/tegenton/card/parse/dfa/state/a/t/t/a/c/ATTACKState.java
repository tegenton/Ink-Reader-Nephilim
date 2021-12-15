package tegenton.card.parse.dfa.state.a.t.t.a.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.t.t.a.ATTACState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.object.ObjectVerb;
import java.util.Optional;

public class ATTACKState extends ATTACState {
    private static final ATTACKState INSTANCE = new ATTACKState();

    public static ATTACKState state() {
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
            case '\0', ' ' -> Optional.of(ObjectVerb.ATTACK);
            default -> Optional.empty();
        };
    }
}
