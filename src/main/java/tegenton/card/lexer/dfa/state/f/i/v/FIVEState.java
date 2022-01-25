package tegenton.card.lexer.dfa.state.f.i.v;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.f.i.FIVState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.Optional;

public class FIVEState extends FIVState {
    private static final FIVEState INSTANCE = new FIVEState();

    /**
     * @return Singleton instance.
     */
    public static FIVEState state() {
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
            case '\0', ' ' -> EnglishNumber.FIVE;
            default -> null;
        });
    }
}
