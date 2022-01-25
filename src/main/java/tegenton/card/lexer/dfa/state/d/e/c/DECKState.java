package tegenton.card.lexer.dfa.state.d.e.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.d.e.DECState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;

import java.util.Optional;

public class DECKState extends DECState {
    private static final DECKState INSTANCE = new DECKState();

    /**
     * @return Singleton instance.
     */
    public static DECKState state() {
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
            case '\0', ' ' -> Zone.DECK;
            default -> null;
        });
    }
}
