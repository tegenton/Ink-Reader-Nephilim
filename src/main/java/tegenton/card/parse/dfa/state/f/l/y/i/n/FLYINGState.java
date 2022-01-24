package tegenton.card.parse.dfa.state.f.l.y.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.f.l.FLYState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;

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
