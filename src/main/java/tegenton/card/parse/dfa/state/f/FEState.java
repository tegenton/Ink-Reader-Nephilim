package tegenton.card.parse.dfa.state.f;

import tegenton.card.parse.dfa.state.FState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;

import java.util.Optional;

public class FEState extends FState {
    private static final FEState INSTANCE = new FEState();

    public static FEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("AR", Keyword.FEAR);
            case 'W' -> new SuffixSubstring("WEST", Noun.FEWEST);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
