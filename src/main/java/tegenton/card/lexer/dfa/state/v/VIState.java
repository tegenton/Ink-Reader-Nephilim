package tegenton.card.lexer.dfa.state.v;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.VState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.CounterName;

import java.util.Optional;

public class VIState extends VState {
    private static final VIState INSTANCE = new VIState();

    /**
     * @return Singleton instance.
     */
    public static VIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'G' -> new SuffixSubstring("GILANCE", Keyword.VIGILANCE);
            case 'T' -> new SuffixSubstring("TALITY", CounterName.VITALITY);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
