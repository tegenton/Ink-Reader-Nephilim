package tegenton.card.parse.dfa.state.w.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.ColorWord;
import tegenton.card.parse.lexicon.game.turn.Duration;

import java.util.Optional;

public class WHIState extends WHState {
    private static final WHIState INSTANCE = new WHIState();

    public static WHIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LE", Duration.WHILE);
            case 'T' -> new SuffixSubstring("TE", ColorWord.WHITE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
