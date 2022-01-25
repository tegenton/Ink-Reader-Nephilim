package tegenton.card.lexer.dfa.state.c.o.l.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.c.COState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class COLORState extends COState {
    private static final COLORState INSTANCE = new COLORState();

    /**
     * @return Singleton instance.
     */
    public static COLORState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LESS", Comparative.LESS);
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'L', '\0', '.', ' ' -> GameNoun.COLOR;
            default -> null;
        });
    }
}
