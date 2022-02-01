package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.s.SAState;
import tegenton.card.lexer.dfa.state.s.SEState;
import tegenton.card.lexer.dfa.state.s.SIState;
import tegenton.card.lexer.dfa.state.s.SOState;
import tegenton.card.lexer.dfa.state.s.SPState;
import tegenton.card.lexer.dfa.state.s.STState;
import tegenton.card.lexer.dfa.state.s.h.u.f.f.l.SHUFFLEState;
import tegenton.card.lexer.dfa.state.s.w.a.m.SWAMPState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SState extends State {
    private static final SState INSTANCE = new SState();

    /**
     * @return Singleton instance.
     */
    public static SState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\u2019', ',', '\0', ' ', '.' -> Morpheme.S;
            default -> null;
        });
    }
}