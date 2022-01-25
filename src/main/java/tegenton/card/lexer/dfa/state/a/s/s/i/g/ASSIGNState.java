package tegenton.card.lexer.dfa.state.a.s.s.i.g;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.SymbolState;
import tegenton.card.lexer.dfa.state.a.ASState;
import tegenton.card.lexer.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class ASSIGNState extends ASState {
    private static final ASSIGNState INSTANCE = new ASSIGNState();

    /**
     * @return Singleton instance.
     */
    public static ASSIGNState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            case 'S' -> this;
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
            case 'E', '\0', ' ' -> TargetVerb.ASSIGN;
            default -> null;
        });
    }
}
