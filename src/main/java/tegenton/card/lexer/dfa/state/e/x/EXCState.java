package tegenton.card.lexer.dfa.state.e.x;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.EXState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class EXCState extends EXState {
    private static final EXCState INSTANCE = new EXCState();

    /**
     * @return Singleton instance.
     */
    public static EXCState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("EPT",
                    SubordinateConjunction.EXCEPT);
            case 'H' -> new SuffixSubstring("HANGE", PlayerVerb.EXCHANGE);
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
