package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.h.HAState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class HState extends State {
    private static final HState INSTANCE = new HState();

    public static HState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> HAState.state();
            case 'E' -> new SuffixSubstring("EIGHT", Noun.HEIGHT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
