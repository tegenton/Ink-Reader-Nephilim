package tegenton.card.lexer.dfa.state.w;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.WState;
import tegenton.card.lexer.dfa.state.w.a.WALState;
import tegenton.card.lexer.dfa.state.w.a.WASState;
import tegenton.card.lexer.dfa.state.w.a.WAYState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class WAState extends WState {
    private static final WAState INSTANCE = new WAState();

    /**
     * @return Singleton instance.
     */
    public static WAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> WALState.state();
            case 'S' -> WASState.state();
            case 'Y' -> WAYState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S' -> ObjectVerb.IS;
            default -> null;
        });
    }
}
