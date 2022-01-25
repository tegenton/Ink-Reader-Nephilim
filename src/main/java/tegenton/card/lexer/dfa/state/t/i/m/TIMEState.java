package tegenton.card.lexer.dfa.state.t.i.m;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.TState;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class TIMEState extends TState {
    private static final TIMEState INSTANCE = new TIMEState();

    /**
     * @return Singleton instance.
     */
    public static TIMEState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
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
            case 'S', '\0', ' ' -> Noun.TIME;
            default -> null;
        });
    }
}
