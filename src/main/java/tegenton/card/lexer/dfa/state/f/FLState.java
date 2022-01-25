package tegenton.card.lexer.dfa.state.f;

import tegenton.card.lexer.dfa.state.FState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.f.l.FLYState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class FLState extends FState {
    private static final FLState INSTANCE = new FLState();

    /**
     * @return Singleton instance.
     */
    public static FLState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("IP", PlayerVerb.FLIP);
            case 'Y' -> FLYState.state();
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
