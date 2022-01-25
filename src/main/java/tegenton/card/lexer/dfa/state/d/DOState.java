package tegenton.card.lexer.dfa.state.d;

import tegenton.card.lexer.dfa.state.DState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.d.o.DONState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class DOState extends DState {
    private static final DOState INSTANCE = new DOState();

    /**
     * @return Singleton instance.
     */
    public static DOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("E", 'S', DOState::state);
            case 'I' -> new INGMorpheme();
            case 'N' -> DONState.state();
            case 'W' -> new SuffixSubstring("WN", Particle.DOWN);
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'I', 'N', ',', '\0', ' ' -> SourceVerb.DO;
            default -> null;
        });
    }
}
