package tegenton.card.lexer.dfa.state.t.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.TOState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAdjective;

import java.util.Optional;

public class TOPState extends TOState {
    private static final TOPState INSTANCE = new TOPState();

    /**
     * @return Singleton instance.
     */
    public static TOPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
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
            case '\0', ' ' -> ObjectAdjective.TOP;
            default -> null;
        });
    }
}
