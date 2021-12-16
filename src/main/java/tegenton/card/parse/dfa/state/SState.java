package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.s.SEState;
import tegenton.card.parse.dfa.state.s.SIState;
import tegenton.card.parse.dfa.state.s.SPState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parse.lexicon.game.type.CardType;
import java.util.Optional;

public class SState extends State {
    private static final SState INSTANCE = new SState();

    public static SState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ACRIFICE", PlayerVerb.SACRIFICE);
            case 'E' -> SEState.state();
            case 'H' -> new SuffixSubstring("HUFFLE", PlayerVerb.SHUFFLE);
            case 'I' -> SIState.state();
            case 'K' -> new SuffixSubstring("KIP", PlayerVerb.SKIP);
            case 'P' -> SPState.state();
            case 'O' -> new SuffixSubstring("ORCERY", CardType.SORCERY);
            case 'T' -> new SuffixSubstring("TRIKE", Keyword.STRIKE);
            case '\0', ' ', '.' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ', '.' -> Optional.of(Morpheme.S);
            default -> Optional.empty();
        };
    }
}
