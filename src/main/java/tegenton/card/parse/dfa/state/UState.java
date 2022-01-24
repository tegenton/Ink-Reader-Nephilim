package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.u.UNState;
import tegenton.card.parse.dfa.state.u.UPState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;

import java.util.Optional;

public class UState extends State {
    private static final UState INSTANCE = new UState();

    /**
     * @return Singleton instance.
     */
    public static UState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> UNState.state();
            case 'P' -> UPState.state();
            case '}' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '}', '\0', ' ' -> Color.U;
            default -> null;
        });
    }
}
