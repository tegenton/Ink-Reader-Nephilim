package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.o.OFState;
import tegenton.card.lexer.dfa.state.o.ONState;
import tegenton.card.lexer.dfa.state.o.ORState;
import tegenton.card.lexer.dfa.state.o.OTState;
import tegenton.card.lexer.dfa.state.o.OWState;
import tegenton.card.lexer.dfa.state.o.p.p.o.n.e.n.OPPONENTState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class OState extends State {
    private static final OState INSTANCE = new OState();

    /**
     * @return Singleton instance.
     */
    public static OState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
