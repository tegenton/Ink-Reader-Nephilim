package tegenton.card.parse.dfa.state.a.b.i.l.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.ABState;
import tegenton.card.parse.dfa.state.a.b.i.l.i.t.ABILITYState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

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
