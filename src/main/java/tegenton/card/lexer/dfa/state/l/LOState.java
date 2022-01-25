package tegenton.card.lexer.dfa.state.l;

import tegenton.card.lexer.dfa.state.LState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.l.o.LOSState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class LOState extends LState {
    private static final LOState INSTANCE = new LOState();

    /**
     * @return Singleton instance.
     */
    public static LOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NG", SubordinateConjunction.LONG);
            case 'O' -> new SuffixSubstring("OK", PlayerVerb.LOOK);
            case 'S' -> LOSState.state();
            case 'Y' -> new SuffixSubstring("YALTY", ObjectAttribute.LOYALTY);
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
