package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.i.IFState;
import tegenton.card.lexer.dfa.state.i.INState;
import tegenton.card.lexer.dfa.state.i.ISState;
import tegenton.card.lexer.dfa.state.i.ITState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class IState extends State {
    private static final IState INSTANCE = new IState();

    /**
     * @return Singleton instance.
     */
    public static IState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    public State transition(final char c) {
        return switch (c) {
            case 'F' -> IFState.state();
            case 'G' -> new SuffixSubstring("GNORE", PlayerVerb.IGNORE);
            case 'N' -> INState.state();
            case 'S' -> ISState.state();
            case 'T' -> ITState.state();
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