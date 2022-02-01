package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.n.ANDState;
import tegenton.card.lexer.dfa.state.a.n.ANTState;
import tegenton.card.lexer.dfa.state.a.n.ANYState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ANState extends AState {
    private static final ANState INSTANCE = new ANState();

    /**
     * @return Singleton instance.
     */
    public static ANState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> ANDState.state();
            case 'T' -> ANTState.state();
            case 'O' -> new SuffixSubstring("OTHER", Determiner.ANOTHER);
            case 'Y' -> ANYState.state();
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
            case '\0', ' ' -> Determiner.AN;
            default -> null;
        });
    }
}