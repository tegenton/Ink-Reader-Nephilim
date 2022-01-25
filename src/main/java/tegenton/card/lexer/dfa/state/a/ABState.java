package tegenton.card.lexer.dfa.state.a;

import tegenton.card.lexer.dfa.state.AState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.a.b.i.l.i.ABILITState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetAdjective;

import java.util.Optional;

public class ABState extends AState {
    private static final ABState INSTANCE = new ABState();

    /**
     * @return Singleton instance.
     */
    public static ABState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new InfixSubstring("ILI", 'T', ABILITState::state);
            case 'L' -> new SuffixSubstring("LE", TargetAdjective.ABLE);
            case 'O' -> new SuffixSubstring("OVE", Preposition.ABOVE);
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
