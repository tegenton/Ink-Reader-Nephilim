package tegenton.card.lexer.dfa.state.e.n.c.h.a.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.e.n.ENCState;
import tegenton.card.lexer.dfa.state.e.n.c.h.a.n.t.m.e.n.ENCHANTMENTState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Optional;

public class ENCHANTState extends ENCState {
    private static final ENCHANTState INSTANCE = new ENCHANTState();

    /**
     * @return Singleton instance.
     */
    public static ENCHANTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'M' -> new InfixSubstring("MEN", 'T', ENCHANTMENTState::state);
            case 'E' -> new EDMorpheme();
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
            case 'E', '\0', ' ' -> Keyword.ENCHANT;
            default -> null;
        });
    }
}
