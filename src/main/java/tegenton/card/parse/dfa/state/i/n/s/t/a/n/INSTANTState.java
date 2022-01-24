package tegenton.card.parse.dfa.state.i.n.s.t.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.i.n.s.t.a.INSTANState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class INSTANTState extends INSTANState {
    private static final INSTANTState INSTANCE = new INSTANTState();

    /**
     * @return Singleton instance.
     */
    public static INSTANTState state() {
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
            case '\0', '.', ' ' -> CardType.INSTANT;
            default -> null;
        });
    }
}
