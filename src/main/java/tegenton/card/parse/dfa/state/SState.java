package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.s.*;
import tegenton.card.parse.dfa.state.s.h.u.f.f.l.SHUFFLEState;
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
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> SAState.state();
            case 'E' -> SEState.state();
            case 'H' -> new InfixSubstring("HUFFL", 'E', SHUFFLEState::state);
            case 'I' -> SIState.state();
            case 'K' -> new SuffixSubstring("KIP", PlayerVerb.SKIP);
            case 'P' -> SPState.state();
            case 'O' -> SOState.state();
            case 'T' -> STState.state();
            case 'W' -> new InfixSubstring("WAM", 'P', SWAMPState::state);
            case '\u2019' -> PossessiveState.state();
            case ',', '\0', ' ', '.' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\u2019', ',', '\0', ' ', '.' -> Morpheme.S;
            default -> null;
        });
    }
}
