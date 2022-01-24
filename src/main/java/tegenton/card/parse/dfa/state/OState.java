package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.o.OFState;
import tegenton.card.parse.dfa.state.o.ONState;
import tegenton.card.parse.dfa.state.o.ORState;
import tegenton.card.parse.dfa.state.o.OTState;
import tegenton.card.parse.dfa.state.o.OWState;
import tegenton.card.parse.dfa.state.o.p.p.o.n.e.n.OPPONENTState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class OState extends State {
    private static final OState INSTANCE = new OState();

    public static OState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'F' -> OFState.state();
            case 'N' -> ONState.state();
            case 'P' -> new InfixSubstring("PPONEN", 'T', OPPONENTState::state);
            case 'R' -> ORState.state();
            case 'T' -> OTState.state();
            case 'U' -> new SuffixSubstring("UT", Preposition.OUT);
            case 'V' -> new SuffixSubstring("VER", Adverb.OVER);
            case 'W' -> OWState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
