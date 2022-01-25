package tegenton.card.lexer.dfa.state.c;

import tegenton.card.lexer.dfa.state.CState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.h.CHOState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class CHState extends CState {
    private static final CHState INSTANCE = new CHState();

    /**
     * @return Singleton instance.
     */
    public static CHState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ANGE", PlayerVerb.CHANGE);
            case 'O' -> CHOState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return super.produce(c);
    }
}
