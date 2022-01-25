package tegenton.card.lexer.dfa.state.m.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.m.MAState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class MAYState extends MAState {
    private static final MAYState INSTANCE = new MAYState();

    /**
     * @return Singleton instance.
     */
    public static MAYState state() {
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
            case '\0', ' ' -> PlayerVerb.MAY;
            default -> null;
        });
    }
}
