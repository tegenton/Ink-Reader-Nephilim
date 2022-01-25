package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.h.HAState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class HState extends State {
    private static final HState INSTANCE = new HState();

    /**
     * @return Singleton instance.
     */
    public static HState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> HAState.state();
            case 'E' -> new SuffixSubstring("EIGHT", Noun.HEIGHT);
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
