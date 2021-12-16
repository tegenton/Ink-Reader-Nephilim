package tegenton.card.parse.dfa.state.r;

import tegenton.card.parse.dfa.state.RState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.player.PlayerVerb;
import java.util.Optional;

public class REState extends RState {
    private static final REState INSTANCE = new REState();

    public static REState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ACH", Keyword.REACH);
            case 'G' -> new SuffixSubstring("GENERATE", PlayerVerb.REGENERATE);
            case 'M' -> new SuffixSubstring("MOVE", PlayerVerb.REMOVE);
            case 'T' -> new SuffixSubstring("TURN", PlayerVerb.RETURN);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
