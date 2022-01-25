package tegenton.card.lexer.dfa.state.n.a.m;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.NState;
import tegenton.card.lexer.dfa.state.e.EDState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class NAMEState extends NState {
    private static final NAMEState INSTANCE = new NAMEState();

    /**
     * @return Singleton instance.
     */
    public static NAMEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
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
            case 'D', '\0', ' ' -> ObjectAttribute.NAME;
            default -> null;
        });
    }
}
