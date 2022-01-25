package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.t.ATTState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.TriggerWord;

import java.util.Optional;

public class ATState extends AState {
    private static final ATState INSTANCE = new ATState();

    /**
     * @return Singleton instance.
     */
    public static ATState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> ATTState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(TriggerWord.AT);
            default -> Optional.empty();
        };
    }
}
