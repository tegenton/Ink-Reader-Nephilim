package tegenton.card.lexer.dfa.state.c.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.COState;
import tegenton.card.lexer.dfa.state.c.o.u.n.t.e.COUNTERState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class COUState extends COState {
    private static final COUState INSTANCE = new COUState();

    /**
     * @return Singleton instance.
     */
    public static COUState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LD", PlayerVerb.COULD);
            case 'N' -> new InfixSubstring("NTE", 'R', COUNTERState::state);
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
