package tegenton.card.parse.dfa.state.w.a.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.w.a.WALState;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class WALKState extends WALState {
    private static final WALKState INSTANCE = new WALKState();

    public static WALKState state() {
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
            case '\0', ' ' -> Optional.of(Keyword.WALK);
            default -> Optional.empty();
        };
    }
}