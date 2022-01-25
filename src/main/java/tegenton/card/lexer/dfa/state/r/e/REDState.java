package tegenton.card.lexer.dfa.state.r.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.r.REState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;

import java.util.Optional;

public class REDState extends REState {
    private static final REDState INSTANCE = new REDState();

    /**
     * @return Singleton instance.
     */
    public static REDState state() {
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
            case '\0', '.', ' ' -> ColorWord.RED;
            default -> null;
        });
    }
}
