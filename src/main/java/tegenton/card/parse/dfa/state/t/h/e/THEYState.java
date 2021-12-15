package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.player.PlayerNoun;
import java.util.Optional;

public class THEYState extends THEState {
    private static final THEYState INSTANCE = new THEYState();

    public static THEYState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        switch (c) {
            default -> throw new IllegalStateException("Cannot transition from THEYState on " + c);
        }
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(PlayerNoun.THEY);
            default -> Optional.empty();
        };
    }
}
