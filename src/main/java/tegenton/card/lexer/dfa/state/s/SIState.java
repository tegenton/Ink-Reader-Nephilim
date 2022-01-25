package tegenton.card.lexer.dfa.state.s;

import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.s.i.SIXState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.turn.Duration;

import java.util.Optional;

public class SIState extends SState {
    private static final SIState INSTANCE = new SIState();

    /**
     * @return Singleton instance.
     */
    public static SIState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NCE", Duration.SINCE);
            case 'X' -> SIXState.state();
            case 'Z' -> new SuffixSubstring("ZE", PlayerAttribute.SIZE);
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
