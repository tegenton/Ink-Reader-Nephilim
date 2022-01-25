package tegenton.card.lexer.dfa.state.s.e.v.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.s.e.v.SEVEState;
import tegenton.card.lexer.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.Optional;

public class SEVENState extends SEVEState {
    private static final SEVENState INSTANCE = new SEVENState();

    /**
     * @return Singleton instance.
     */
    public static SEVENState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.SEVEN);
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
            case '\0', '.', ' ' -> EnglishNumber.SEVEN;
            default -> null;
        });
    }
}
