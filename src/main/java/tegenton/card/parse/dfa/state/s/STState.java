package tegenton.card.parse.dfa.state.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.t.STEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;

import java.util.Optional;

public class STState extends SState {
    private static final STState INSTANCE = new STState();

    /**
     * @return Singleton instance.
     */
    public static STState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> STEState.state();
            case 'I' -> new SuffixSubstring("ILL", Adverb.STILL);
            case 'R' -> new SuffixSubstring("RIKE", Keyword.STRIKE);
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
