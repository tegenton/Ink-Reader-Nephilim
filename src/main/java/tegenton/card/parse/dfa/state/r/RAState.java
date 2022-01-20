package tegenton.card.parse.dfa.state.r;

import tegenton.card.parse.dfa.state.RState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.card.Name;

import java.util.Optional;

public class RAState extends RState {
    private static final RAState INSTANCE = new RAState();

    public static RAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NDOM", Noun.RANDOM);
            case 'T' -> new SuffixSubstring("TS", Name.RATS);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
