package tegenton.card.parse.dfa.state.t.h.e;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.h.THEState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetNoun;

import java.util.Optional;

public class THEYState extends THEState {
    private static final THEYState INSTANCE = new THEYState();

    /**
     * @return Singleton instance.
     */
    public static THEYState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\u2019' -> AState.state();
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
            case '\u2019', '\0', ' ' -> TargetNoun.THEY;
            default -> null;
        });
    }
}
