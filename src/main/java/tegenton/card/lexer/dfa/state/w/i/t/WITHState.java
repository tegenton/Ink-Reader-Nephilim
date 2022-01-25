package tegenton.card.lexer.dfa.state.w.i.t;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.OState;
import tegenton.card.lexer.dfa.state.WState;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class WITHState extends WState {
    private static final WITHState INSTANCE = new WITHState();

    /**
     * @return Singleton instance.
     */
    public static WITHState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'O' -> OState.state();
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
            case 'O', '\0', ' ' -> Preposition.WITH;
            default -> null;
        });
    }
}
