package tegenton.card.lexer.dfa.state.w.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.w.WHState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.turn.Duration;

import java.util.Optional;

public class WHIState extends WHState {
    private static final WHIState INSTANCE = new WHIState();

    /**
     * @return Singleton instance.
     */
    public static WHIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LE", Duration.WHILE);
            case 'T' -> new SuffixSubstring("TE", ColorWord.WHITE);
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
