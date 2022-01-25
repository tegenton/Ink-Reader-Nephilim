package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.a.ABState;
import tegenton.card.lexer.dfa.state.a.ADState;
import tegenton.card.lexer.dfa.state.a.ALState;
import tegenton.card.lexer.dfa.state.a.AMState;
import tegenton.card.lexer.dfa.state.a.ANState;
import tegenton.card.lexer.dfa.state.a.ARState;
import tegenton.card.lexer.dfa.state.a.ASState;
import tegenton.card.lexer.dfa.state.a.ATState;
import tegenton.card.lexer.dfa.state.a.c.t.i.ACTIVState;
import tegenton.card.lexer.dfa.state.a.u.r.AURAState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.turn.Chronology;

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
