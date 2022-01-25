package tegenton.card.lexer.dfa.state.c.o.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.o.CONState;
import tegenton.card.lexer.dfa.state.c.o.n.t.CONTRState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerAdverb;

import java.util.Optional;

public class CONTState extends CONState {
    private static final CONTState INSTANCE = new CONTState();

    /**
     * @return Singleton instance.
     */
    public static CONTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("INUOUSLY",
                    PlayerAdverb.CONTINUOUSLY);
            case 'R' -> CONTRState.state();
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
