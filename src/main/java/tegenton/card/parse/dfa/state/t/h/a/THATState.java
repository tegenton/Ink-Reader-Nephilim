package tegenton.card.parse.dfa.state.t.h.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.h.THAState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class THATState extends THAState {
    private static final THATState INSTANCE = new THATState();

    /**
     * @return Singleton instance.
     */
    public static THATState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case ' ', '\0' -> Determiner.THAT;
            default -> null;
        });
    }
}
