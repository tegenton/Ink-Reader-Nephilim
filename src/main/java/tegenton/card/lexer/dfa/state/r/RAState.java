package tegenton.card.lexer.dfa.state.r;

import tegenton.card.lexer.dfa.state.RState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.card.CardName;

import java.util.Optional;

public class RAState extends RState {
    private static final RAState INSTANCE = new RAState();

    /**
     * @return Singleton instance.
     */
    public static RAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NDOM", Noun.RANDOM);
            case 'T' -> new SuffixSubstring("TS", CardName.RATS);
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
