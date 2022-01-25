package tegenton.card.lexer.dfa.state.a.u.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.EnchantmentType;

import java.util.Optional;

public class AURAState extends AState {
    private static final AURAState INSTANCE = new AURAState();

    /**
     * @return Singleton instance.
     */
    public static AURAState state() {
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
            case 'S', '\0', ' ' -> EnchantmentType.AURA;
            default -> null;
        });
    }
}
