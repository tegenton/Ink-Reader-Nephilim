package tegenton.card.parse.dfa.state.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.VState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.game.type.CounterName;

import java.util.Optional;

public class VIState extends VState {
    private static final VIState INSTANCE = new VIState();

    public static VIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'G' -> new SuffixSubstring("GILANCE", Keyword.VIGILANCE);
            case 'T' -> new SuffixSubstring("TALITY", CounterName.VITALITY);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
