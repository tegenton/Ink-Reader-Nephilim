package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.s.*;
import tegenton.card.parse.dfa.state.s.w.a.m.SWAMPState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SState extends State {
    private static final SState INSTANCE = new SState();

    public static SState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> SAState.state();
            case 'E' -> SEState.state();
            case 'H' -> new SuffixSubstring("HUFFLE", PlayerVerb.SHUFFLE);
            case 'I' -> SIState.state();
            case 'K' -> new SuffixSubstring("KIP", PlayerVerb.SKIP);
            case 'P' -> SPState.state();
            case 'O' -> SOState.state();
            case 'T' -> STState.state();
            case 'W' -> new InfixSubstring("WAM", 'P', SWAMPState::state);
            case '\0', ' ', '.' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ', '.' -> Morpheme.S;
            default -> null;
        });
    }
}
