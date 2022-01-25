package tegenton.card.lexer.dfa.state.o;

import tegenton.card.lexer.dfa.state.OState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ORState extends OState {
    private static final ORState INSTANCE = new ORState();

    /**
     * @return Singleton instance.
     */
    public static ORState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> new SuffixSubstring("DER", Noun.ORDER);
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Conjunction.OR;
            default -> null;
        });
    }
}
