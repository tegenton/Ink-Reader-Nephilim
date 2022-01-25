package tegenton.card.lexer.dfa.state.p.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.p.PRState;
import tegenton.card.lexer.dfa.state.p.r.o.d.u.c.PRODUCEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Optional;

public class PROState extends PRState {
    private static final PROState INSTANCE = new PROState();

    /**
     * @return Singleton instance.
     */
    public static PROState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> new InfixSubstring("DUC", 'E', PRODUCEState::state);
            case 'T' -> new SuffixSubstring("TECTION", Keyword.PROTECTION);
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
