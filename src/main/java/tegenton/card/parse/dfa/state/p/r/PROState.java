package tegenton.card.parse.dfa.state.p.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.PRState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class PROState extends PRState {
    private static final PROState INSTANCE = new PROState();

    public static PROState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> new SuffixSubstring("DUCE", SourceVerb.PRODUCE);
            case 'T' -> new SuffixSubstring("TECTION", Keyword.PROTECTION);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
