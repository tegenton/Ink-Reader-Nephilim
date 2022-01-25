package tegenton.card.lexer.dfa.state.p.r.e.v.e.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.p.PRState;
import tegenton.card.lexer.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;


public class PREVENTState extends PRState {
    private static final PREVENTState INSTANCE = new PREVENTState();

    /**
     * @return Singleton instance.
     */
    public static PREVENTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
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
            case 'E', '\0', ' ' -> PlayerVerb.PREVENT;
            default -> null;
        });
    }
}
