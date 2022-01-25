package tegenton.card.lexer.dfa.state.l.e.a.v;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.l.e.a.LEAVState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class LEAVEState extends LEAVState {
    private static final LEAVEState INSTANCE = new LEAVEState();

    /**
     * @return Singleton instance.
     */
    public static LEAVEState state() {
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
            case '\0', ' ' -> ObjectVerb.LEAVE;
            default -> null;
        });
    }
}
