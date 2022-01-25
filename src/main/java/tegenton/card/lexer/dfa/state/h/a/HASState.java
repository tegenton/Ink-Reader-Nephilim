package tegenton.card.lexer.dfa.state.h.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.h.HAState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class HASState extends HAState {
    private static final HASState INSTANCE = new HASState();

    /**
     * @return Singleton instance.
     */
    public static HASState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new SuffixSubstring("TE", Keyword.HASTE);
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
            case '\0', ' ' -> ObjectVerb.HAVE;
            default -> null;
        });
    }
}
