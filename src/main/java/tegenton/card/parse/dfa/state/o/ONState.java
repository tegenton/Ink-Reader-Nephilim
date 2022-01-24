package tegenton.card.parse.dfa.state.o;

import tegenton.card.parse.dfa.state.OState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.state.o.n.ONEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ONState extends OState {
    private static final ONState INSTANCE = new ONState();

    /**
     * @return Singleton instance.
     */
    public static ONState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new SuffixSubstring("CE", Adverb.ONCE);
            case 'E' -> ONEState.state();
            case 'L' -> new SuffixSubstring("LY", Adverb.ONLY);
            case 'T' -> TState.state();
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
            case 'T', '\0', ' ' -> Preposition.ON;
            default -> null;
        });
    }
}
