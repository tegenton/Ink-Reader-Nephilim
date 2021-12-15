package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.object.ObjectNoun;
import java.util.Optional;

public class ITState extends IState {
    private static final ITState INSTANCE = new ITState();

    public static ITState state() {
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
            case '\0', ' ' -> Optional.of(ObjectNoun.IT);
            default -> Optional.empty();
        };
    }
}
