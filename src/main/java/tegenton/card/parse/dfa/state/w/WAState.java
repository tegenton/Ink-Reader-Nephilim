package tegenton.card.parse.dfa.state.w;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.dfa.state.w.a.WALState;
import tegenton.card.parse.dfa.state.w.a.WASState;
import tegenton.card.parse.dfa.state.w.a.WAYState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class WAState extends WState {
    private static final WAState INSTANCE = new WAState();

    public static WAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> WALState.state();
            case 'S' -> WASState.state();
            case 'Y' -> WAYState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S' -> ObjectVerb.IS;
            default -> null;
        });
    }
}
