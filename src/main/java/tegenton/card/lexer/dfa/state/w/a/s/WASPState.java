package tegenton.card.lexer.dfa.state.w.a.s;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.w.a.WASState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.card.CardName;

import java.util.Optional;

public class WASPState extends WASState {
    private static final WASPState INSTANCE = new WASPState();

    /**
     * @return Singleton instance.
     */
    public static WASPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> CardName.WASP;
            default -> null;
        });
    }
}
