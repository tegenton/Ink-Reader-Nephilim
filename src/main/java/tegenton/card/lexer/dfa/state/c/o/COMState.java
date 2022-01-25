package tegenton.card.lexer.dfa.state.c.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.COState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.turn.Phase;

import java.util.Optional;

public class COMState extends COState {
    private static final COMState INSTANCE = new COMState();

    /**
     * @return Singleton instance.
     */
    public static COMState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new SuffixSubstring("BAT", Phase.COMBAT);
            case 'P' -> new SuffixSubstring("PLETELY", Adverb.COMPLETELY);
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
