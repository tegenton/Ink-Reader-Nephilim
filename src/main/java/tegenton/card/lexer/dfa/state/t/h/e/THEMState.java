package tegenton.card.lexer.dfa.state.t.h.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.t.h.THEState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetNoun;

import java.util.Optional;

public class THEMState extends THEState {
    private static final THEMState INSTANCE = new THEMState();

    /**
     * @return Singleton instance.
     */
    public static THEMState state() {
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
            case '\0', ' ' -> TargetNoun.THEM;
            default -> null;
        });
    }
}
