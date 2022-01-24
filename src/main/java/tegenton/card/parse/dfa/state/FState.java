package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.f.FEState;
import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.state.f.FLState;
import tegenton.card.parse.dfa.state.f.FOState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class FState extends State {
    private static final FState INSTANCE = new FState();

    /**
     * @return Singleton instance.
     */
    public static FState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ACE", ObjectAttribute.FACE);
            case 'E' -> FEState.state();
            case 'I' -> FIState.state();
            case 'L' -> FLState.state();
            case 'O' -> FOState.state();
            case 'R' -> new SuffixSubstring("ROM", Preposition.FROM);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
