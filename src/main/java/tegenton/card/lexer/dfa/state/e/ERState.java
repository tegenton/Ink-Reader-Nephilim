package tegenton.card.lexer.dfa.state.e;

import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.PossessiveState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ERState extends EState {
    private static final ERState INSTANCE = new ERState();

    /**
     * @return Singleton instance.
     */
    public static ERState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\u2019' -> PossessiveState.state();
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\u2019', ',', '.', '\0', ' ' -> Morpheme.ER;
            default -> null;
        });
    }
}
