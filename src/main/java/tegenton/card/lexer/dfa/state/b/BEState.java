package tegenton.card.lexer.dfa.state.b;

import tegenton.card.lexer.dfa.state.BState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.b.e.c.o.m.BECOMEState;
import tegenton.card.lexer.dfa.state.b.e.g.i.BEGINState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.turn.Chronology;

import java.util.Optional;

public class BEState extends BState {
    private static final BEState INSTANCE = new BEState();

    /**
     * @return Singleton instance.
     */
    public static BEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new InfixSubstring("COM", 'E', BECOMEState::state);
            case 'E' -> new SuffixSubstring("EN", Morpheme.ED);
            case 'F' -> new SuffixSubstring("FORE", Chronology.BEFORE);
            case 'G' -> new InfixSubstring("GI", 'N', BEGINState::state);
            case 'Y' -> new SuffixSubstring("YOND", Preposition.BEYOND);
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
            case '\0', ' ' -> GameVerb.BE;
            default -> null;
        });
    }
}
