package tegenton.card.lexer.dfa.state.a.b.i.l.i;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.ABState;
import tegenton.card.lexer.dfa.state.a.b.i.l.i.t.ABILITYState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;

import java.util.Optional;

public class ABILITState extends ABState {
    private static final ABILITState INSTANCE = new ABILITState();

    /**
     * @return Singleton instance.
     */
    public static ABILITState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("IES", Morpheme.S);
            case 'Y' -> ABILITYState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'I' -> GameNoun.ABILITY;
            default -> null;
        });
    }
}
