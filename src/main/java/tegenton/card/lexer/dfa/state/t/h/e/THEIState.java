package tegenton.card.lexer.dfa.state.t.h.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.PossessiveState;
import tegenton.card.lexer.dfa.state.t.h.THEState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetNoun;

import java.util.Optional;

public class THEIState extends THEState {
    private static final THEIState INSTANCE = new THEIState();

    /**
     * @return Singleton instance.
     */
    public static THEIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'R' -> PossessiveState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case 'R' -> Optional.of(TargetNoun.THEY);
            default -> Optional.empty();
        };
    }
}
