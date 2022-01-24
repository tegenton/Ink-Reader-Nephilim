package tegenton.card.parse.dfa.state.m;

import tegenton.card.parse.dfa.state.MState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.a.MANState;
import tegenton.card.parse.dfa.state.m.a.MAYState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerAttribute;
import tegenton.card.parse.lexicon.game.turn.Phase;

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
