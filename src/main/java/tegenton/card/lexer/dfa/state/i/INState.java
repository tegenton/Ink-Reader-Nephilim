package tegenton.card.lexer.dfa.state.i;

import tegenton.card.lexer.dfa.state.IState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexer.dfa.state.i.n.INGState;
import tegenton.card.lexer.dfa.state.i.n.INSState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Optional;

public class INState extends IState {
    private static final INState INSTANCE = new INState();

    /**
     * @return Singleton instance.
     */
    public static INState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> new SuffixSubstring("DESTRUCTIBLE",
                    Keyword.INDESTRUCTIBLE);
            case 'G' -> INGState.state();
            case 'S' -> INSState.state();
            case 'T' -> TState.state();
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
            case 'T', '\0', ' ' -> Optional.of(Preposition.IN);
            default -> Optional.empty();
        };
    }
}
