package tegenton.card.parse.dfa.state.r;

import tegenton.card.parse.dfa.state.RState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.r.e.REDState;
import tegenton.card.parse.dfa.state.r.e.RESState;
import tegenton.card.parse.dfa.state.r.e.g.e.n.e.r.a.t.REGENERATEState;
import tegenton.card.parse.dfa.state.r.e.m.o.v.REMOVEState;
import tegenton.card.parse.dfa.state.r.e.p.l.a.REPLACState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REState extends RState {
    private static final REState INSTANCE = new REState();

    public static REState state() {
        return INSTANCE;
    }

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

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
