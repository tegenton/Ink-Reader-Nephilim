package tegenton.card.parse.dfa.state.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.e.ENState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.turn.Step;

import java.util.Optional;

public class ENDState extends ENState {
    private static final ENDState INSTANCE = new ENDState();

    /**
     * @return Singleton instance.
     */
    public static ENDState state() {
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
            case '\0', ' ' -> Step.END;
            default -> null;
        });
    }
}
