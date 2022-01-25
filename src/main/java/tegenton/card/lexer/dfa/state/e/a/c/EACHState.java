package tegenton.card.lexer.dfa.state.e.a.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.e.a.EACState;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class EACHState extends EACState {
    private static final EACHState INSTANCE = new EACHState();

    /**
     * @return Singleton instance.
     */
    public static EACHState state() {
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
            case '\0', ' ' -> Determiner.EACH;
            default -> null;
        });
    }
}
