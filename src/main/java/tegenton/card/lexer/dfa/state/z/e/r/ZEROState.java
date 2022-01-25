package tegenton.card.lexer.dfa.state.z.e.r;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.z.e.ZERState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.Optional;

public class ZEROState extends ZERState {
    private static final ZEROState INSTANCE = new ZEROState();

    /**
     * @return Singleton instance.
     */
    public static ZEROState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> EnglishNumber.ZERO;
            default -> null;
        });
    }
}
