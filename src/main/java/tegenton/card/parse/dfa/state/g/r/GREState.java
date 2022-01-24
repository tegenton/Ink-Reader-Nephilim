package tegenton.card.parse.dfa.state.g.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.g.GRState;
import tegenton.card.parse.dfa.state.g.r.e.GREAState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.ColorWord;

import java.util.Optional;

public class GREState extends GRState {
    private static final GREState INSTANCE = new GREState();

    /**
     * @return Singleton instance.
     */
    public static GREState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> GREAState.state();
            case 'E' -> new SuffixSubstring("EN", ColorWord.GREEN);
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
