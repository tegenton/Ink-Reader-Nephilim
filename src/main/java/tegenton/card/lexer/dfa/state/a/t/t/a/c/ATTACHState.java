package tegenton.card.lexer.dfa.state.a.t.t.a.c;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.t.t.a.ATTACState;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class ATTACHState extends ATTACState {
    private static final ATTACHState INSTANCE = new ATTACHState();

    /**
     * @return Singleton instance.
     */
    public static ATTACHState state() {
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
            case '\0', ' ' -> PlayerVerb.ATTACH;
            default -> null;
        });
    }
}
