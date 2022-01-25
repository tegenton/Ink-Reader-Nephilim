package tegenton.card.lexer.dfa.state.g;

import tegenton.card.lexer.dfa.state.GState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.g.o.b.l.i.GOBLINState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CreatureType;

import java.util.Optional;

public class GOState extends GState {
    private static final GOState INSTANCE = new GOState();

    /**
     * @return Singleton instance.
     */
    public static GOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'B' -> new InfixSubstring("BLI", 'N', GOBLINState::state);
            case 'L' -> new SuffixSubstring("LEM", CreatureType.GOLEM);
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
