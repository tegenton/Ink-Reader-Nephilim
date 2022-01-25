package tegenton.card.lexer.dfa.state.i.n;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.i.INState;
import tegenton.card.lexer.dfa.state.i.n.s.INSTState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CreatureType;

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
