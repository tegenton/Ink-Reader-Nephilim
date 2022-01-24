package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.a.ABState;
import tegenton.card.parse.dfa.state.a.ADState;
import tegenton.card.parse.dfa.state.a.ALState;
import tegenton.card.parse.dfa.state.a.AMState;
import tegenton.card.parse.dfa.state.a.ANState;
import tegenton.card.parse.dfa.state.a.ARState;
import tegenton.card.parse.dfa.state.a.ASState;
import tegenton.card.parse.dfa.state.a.ATState;
import tegenton.card.parse.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.parse.dfa.state.a.u.r.AURAState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Chronology;

import java.util.Optional;

public class AState extends State {
    private static final AState INSTANCE = new AState();

    /**
     * @return Singleton instance.
     */
    public static AState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> ABState.state();
            case 'C' -> new InfixSubstring("CTI", 'V', ACTIVState::state);
            case 'D' -> ADState.state();
            case 'F' -> new SuffixSubstring("FTER", Chronology.AFTER);
            case 'L' -> ALState.state();
            case 'M' -> AMState.state();
            case 'N' -> ANState.state();
            case 'R' -> ARState.state();
            case 'S' -> ASState.state();
            case 'T' -> ATState.state();
            case 'U' -> new InfixSubstring("UR", 'A', AURAState::state);
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.A;
            default -> null;
        });
    }
}
