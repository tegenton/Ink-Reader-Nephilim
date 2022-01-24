package tegenton.card.parse.dfa.state.t.w.e.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.w.e.n.TWENTState;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class TWENTYState extends TWENTState {
    private static final TWENTYState INSTANCE = new TWENTYState();

    /**
     * @return Singleton instance.
     */
    public static TWENTYState state() {
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
            case '\0', '0' -> EnglishNumber.TWENTY;
            default -> null;
        });
    }
}
