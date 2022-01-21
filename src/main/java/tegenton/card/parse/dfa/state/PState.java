package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.p.PAState;
import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.dfa.state.p.PRState;
import tegenton.card.parse.dfa.state.p.e.r.m.a.n.e.n.PERMANENTState;
import tegenton.card.parse.dfa.state.p.i.l.PILEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class PState extends State {
    private static final PState INSTANCE = new PState();

    public static PState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> PAState.state();
            case 'E' -> new InfixSubstring("ERMANEN", 'T', PERMANENTState::state);
            case 'I' -> new InfixSubstring("IL", 'E', PILEState::state);
            case 'O' -> new SuffixSubstring("OWER", ObjectAttribute.POWER);
            case 'L' -> PLState.state();
            case 'R' -> PRState.state();
            case 'U' -> new SuffixSubstring("UT", PlayerVerb.PUT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
