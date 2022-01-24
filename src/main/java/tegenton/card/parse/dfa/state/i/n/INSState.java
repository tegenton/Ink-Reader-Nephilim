package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.dfa.state.i.n.s.INSTState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CreatureType;

import java.util.Optional;

public class INSState extends INState {
    private static final INSState INSTANCE = new INSState();

    /**
     * @return Singleton instance.
     */
    public static INSState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("ECT", CreatureType.INSECT);
            case 'T' -> INSTState.state();
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
