package tegenton.card.lexer.dfa.state.f.l.y.i.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.f.l.FLYState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.Optional;

public class FLYINGState extends FLYState {
    private static final FLYINGState INSTANCE = new FLYINGState();

    /**
     * @return Singleton instance.
     */
    public static FLYINGState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case ',', '\n', '\0', '.', ';', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\n', '\0', '.', ';', ' ' -> Keyword.FLYING;
            default -> null;
        });
    }
}
