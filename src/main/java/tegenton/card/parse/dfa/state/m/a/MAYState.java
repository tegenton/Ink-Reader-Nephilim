package tegenton.card.parse.dfa.state.m.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.MAState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class MAYState extends MAState {
    private static final MAYState INSTANCE = new MAYState();

    public static MAYState state() {
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
            case '\0', ' ' -> Optional.of(PlayerVerb.MAY);
            default -> Optional.empty();
        };
    }
}
