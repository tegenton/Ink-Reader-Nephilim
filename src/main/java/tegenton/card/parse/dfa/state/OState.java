package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.o.*;
import tegenton.card.parse.dfa.state.o.p.p.o.n.e.n.OPPONENTState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class OState extends State {
    private static final OState INSTANCE = new OState();

    public static OState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'F' -> OFState.state();
            case 'N' -> ONState.state();
            case 'P' -> new InfixSubstring("PPONEN", 'T', OPPONENTState::state);
            case 'R' -> ORState.state();
            case 'T' -> OTState.state();
            case 'W' -> OWState.state();
            case 'V' -> new SuffixSubstring("VER", Adverb.OVER);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
