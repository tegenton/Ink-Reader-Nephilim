package tegenton.card.lexer.dfa.state.t.o;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.TOState;
import tegenton.card.lexer.dfa.state.t.o.u.c.TOUCHState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class TOUState extends TOState {
    private static final TOUState INSTANCE = new TOUState();

    /**
     * @return Singleton instance.
     */
    public static TOUState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new InfixSubstring("C",
                    'H',
                    TOUCHState::state);
            case 'G' -> new SuffixSubstring("GHNESS",
                    ObjectAttribute.TOUGHNESS);
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
