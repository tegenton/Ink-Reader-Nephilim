package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.object.ObjectVerb;
import java.util.Optional;

public class ISState extends IState {
    private static final ISState INSTANCE = new ISState();

    public static ISState state() {
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
            case '\0', ' ' -> Optional.of(ObjectVerb.IS);
            default -> Optional.empty();
        };
    }
}
