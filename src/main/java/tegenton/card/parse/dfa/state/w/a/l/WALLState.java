package tegenton.card.parse.dfa.state.w.a.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.w.a.WALState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CreatureType;
import java.util.Optional;

public class WALLState extends WALState {
    private static final WALLState INSTANCE = new WALLState();

    public static WALLState state() {
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
            case '\0', ' ' -> Optional.of(CreatureType.WALL);
            default -> Optional.empty();
        };
    }
}
