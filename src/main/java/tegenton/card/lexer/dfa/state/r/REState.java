package tegenton.card.lexer.dfa.state.r;

import tegenton.card.lexer.dfa.state.RState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.r.e.REDState;
import tegenton.card.lexer.dfa.state.r.e.RESState;
import tegenton.card.lexer.dfa.state.r.e.g.e.n.e.r.a.t.REGENERATEState;
import tegenton.card.lexer.dfa.state.r.e.m.o.v.REMOVEState;
import tegenton.card.lexer.dfa.state.r.e.p.l.a.REPLACState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REState extends RState {
    private static final REState INSTANCE = new REState();

    /**
     * @return Singleton instance.
     */
    public static REState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ACH", Keyword.REACH);
            case 'D' -> REDState.state();
            case 'G' -> new InfixSubstring("GENERAT",
                    'E',
                    REGENERATEState::state);
            case 'M' -> new InfixSubstring("MOV", 'E', REMOVEState::state);
            case 'P' -> new InfixSubstring("PLA", 'C', REPLACState::state);
            case 'S' -> RESState.state();
            case 'T' -> new SuffixSubstring("TURN", PlayerVerb.RETURN);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
