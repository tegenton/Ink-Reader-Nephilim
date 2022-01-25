package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.p.PAState;
import tegenton.card.lexer.dfa.state.p.PLState;
import tegenton.card.lexer.dfa.state.p.PRState;
import tegenton.card.lexer.dfa.state.p.e.r.m.a.n.e.n.PERMANENTState;
import tegenton.card.lexer.dfa.state.p.i.l.PILEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class PState extends State {
    private static final PState INSTANCE = new PState();

    /**
     * @return Singleton instance.
     */
    public static PState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> PAState.state();
            case 'E' -> new InfixSubstring("ERMANEN",
                    'T',
                    PERMANENTState::state);
            case 'I' -> new InfixSubstring("IL", 'E', PILEState::state);
            case 'O' -> new SuffixSubstring("OWER", ObjectAttribute.POWER);
            case 'L' -> PLState.state();
            case 'R' -> PRState.state();
            case 'U' -> new SuffixSubstring("UT", PlayerVerb.PUT);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
