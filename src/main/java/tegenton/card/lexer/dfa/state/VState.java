package tegenton.card.lexer.dfa.state;

import tegenton.card.lexer.dfa.state.v.VIState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class VState extends tegenton.card.lexer.dfa.state.State {
    private static final VState INSTANCE = new VState();

    /**
     * @return Singleton instance.
     */
    public static VState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ALUE", ObjectAttribute.VALUE);
            case 'I' -> VIState.state();
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
