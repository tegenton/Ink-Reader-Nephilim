package tegenton.card.parse.dfa.state.w.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetModifier;
import tegenton.card.parse.lexicon.game.source.target.TargetNoun;

import java.util.Optional;

public class WHOState extends WHState {
    private static final WHOState INSTANCE = new WHOState();

    /**
     * @return Singleton instance.
     */
    public static WHOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'M' -> this;
            case 'S' -> new SuffixSubstring("SE", TargetModifier.POSSESSIVE);
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', ' ' -> TargetNoun.WHO;
            default -> null;
        });
    }
}
