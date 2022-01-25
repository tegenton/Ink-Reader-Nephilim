package tegenton.card.lexer.dfa.state.d.e.c.l.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.d.DEState;
import tegenton.card.lexer.dfa.state.d.e.c.l.a.r.DECLAREState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DECLARState extends DEState {
    private static final DECLARState INSTANCE = new DECLARState();

    /**
     * @return Singleton instance.
     */
    public static DECLARState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> DECLAREState.state();
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
            case 'D', '\0', ' ' -> PlayerVerb.DECLARE;
            default -> null;
        });
    }
}
