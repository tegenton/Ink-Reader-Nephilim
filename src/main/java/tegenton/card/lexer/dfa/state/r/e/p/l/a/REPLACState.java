package tegenton.card.lexer.dfa.state.r.e.p.l.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.r.REState;
import tegenton.card.lexer.dfa.state.r.e.p.l.a.c.REPLACEState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REPLACState extends REState {
    private static final REPLACState INSTANCE = new REPLACState();

    /**
     * @return Singleton instance.
     */
    public static REPLACState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> REPLACEState.state();
            case 'I' -> new INGMorpheme();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'I' -> PlayerVerb.REPLACE;
            default -> null;
        });
    }
}
