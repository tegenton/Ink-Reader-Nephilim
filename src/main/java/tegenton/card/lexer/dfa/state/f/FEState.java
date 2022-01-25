package tegenton.card.lexer.dfa.state.f;

import tegenton.card.lexer.dfa.state.FState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Optional;

public class FEState extends FState {
    private static final FEState INSTANCE = new FEState();

    /**
     * @return Singleton instance.
     */
    public static FEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AR", Keyword.FEAR);
            case 'W' -> new SuffixSubstring("WEST", Noun.FEWEST);
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
