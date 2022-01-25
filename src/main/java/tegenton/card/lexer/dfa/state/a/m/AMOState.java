package tegenton.card.lexer.dfa.state.a.m;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.AMState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class AMOState extends AMState {
    private static final AMOState INSTANCE = new AMOState();

    /**
     * @return Singleton instance.
     */
    public static AMOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NG", Preposition.AMONG);
            case 'U' -> new SuffixSubstring("UNT", Noun.AMOUNT);
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
