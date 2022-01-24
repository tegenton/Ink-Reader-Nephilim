package tegenton.card.parse.dfa.state.w.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.w.WAState;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class WAYState extends WAState {
    private static final WAYState INSTANCE = new WAYState();

    /**
     * @return Singleton instance.
     */
    public static WAYState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
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
            case '\0', '.', ' ' -> Noun.WAY;
            default -> null;
        });
    }
}
