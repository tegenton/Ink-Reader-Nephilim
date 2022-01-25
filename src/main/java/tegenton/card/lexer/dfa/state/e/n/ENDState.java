package tegenton.card.lexer.dfa.state.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.e.ENState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.turn.Step;

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
