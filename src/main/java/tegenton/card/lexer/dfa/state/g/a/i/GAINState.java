package tegenton.card.lexer.dfa.state.g.a.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.GState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class GAINState extends GState {
    private static final GAINState INSTANCE = new GAINState();

    /**
     * @return Singleton instance.
     */
    public static GAINState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
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
            case '\0', ' ' -> TargetVerb.GAIN;
            default -> null;
        });
    }
}
