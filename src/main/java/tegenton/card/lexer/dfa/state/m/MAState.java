package tegenton.card.lexer.dfa.state.m;

import tegenton.card.lexer.dfa.state.MState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.m.a.MANState;
import tegenton.card.lexer.dfa.state.m.a.MAYState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.turn.Phase;

import java.util.Optional;

public class MAState extends MState {
    private static final MAState INSTANCE = new MAState();

    /**
     * @return Singleton instance.
     */
    public static MAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("IN", Phase.MAIN);
            case 'N' -> MANState.state();
            case 'X' -> new SuffixSubstring("XIMUM", PlayerAttribute.MAXIMUM);
            case 'Y' -> MAYState.state();
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
