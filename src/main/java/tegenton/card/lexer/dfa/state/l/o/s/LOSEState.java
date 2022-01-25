package tegenton.card.lexer.dfa.state.l.o.s;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.l.o.LOSState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class LOSEState extends LOSState {
    private static final LOSEState INSTANCE = new LOSEState();

    /**
     * @return Singleton instance.
     */
    public static LOSEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> TargetVerb.LOSE;
            default -> null;
        });
    }
}
