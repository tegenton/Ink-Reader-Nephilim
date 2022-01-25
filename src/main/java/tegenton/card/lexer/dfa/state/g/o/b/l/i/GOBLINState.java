package tegenton.card.lexer.dfa.state.g.o.b.l.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.g.GOState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CreatureType;

import java.util.Optional;

public class GOBLINState extends GOState {
    private static final GOBLINState INSTANCE = new GOBLINState();

    /**
     * @return Singleton instance.
     */
    public static GOBLINState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
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
            case 'S', '\0', ' ' -> CreatureType.GOBLIN;
            default -> null;
        });
    }
}
