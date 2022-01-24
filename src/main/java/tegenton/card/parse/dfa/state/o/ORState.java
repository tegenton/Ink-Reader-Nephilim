package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Conjunction;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

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
