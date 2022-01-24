package tegenton.card.parse.dfa.state.d.o.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.o.n.DONtState;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class DONTState extends DONtState {
    private static final DONTState INSTANCE = new DONTState();

    /**
     * @return Singleton instance.
     */
    public static DONTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
