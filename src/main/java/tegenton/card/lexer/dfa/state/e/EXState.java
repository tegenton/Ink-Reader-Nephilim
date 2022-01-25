package tegenton.card.lexer.dfa.state.e;

import tegenton.card.lexer.dfa.state.EState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.x.EXCState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;

import java.util.Optional;

public class EXState extends EState {
    private static final EXState INSTANCE = new EXState();

    /**
     * @return Singleton instance.
     */
    public static EXState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> EXCState.state();
            case 'I' -> new SuffixSubstring("ILE", Zone.EXILE);
            case 'T' -> new SuffixSubstring("TRA", Adjective.EXTRA);
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
