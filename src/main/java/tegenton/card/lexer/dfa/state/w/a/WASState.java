package tegenton.card.lexer.dfa.state.w.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.w.WAState;
import tegenton.card.lexer.dfa.state.w.a.s.WASPState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class WASState extends WAState {
    private static final WASState INSTANCE = new WASState();

    /**
     * @return Singleton instance.
     */
    public static WASState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("N\u2019T", Adverb.NOT);
            case 'P' -> WASPState.state();
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
            case 'N', '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
