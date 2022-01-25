package tegenton.card.lexer.dfa.state.t.a.p;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.t.a.TAPState;
import tegenton.card.lexer.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class TAPPState extends TAPState {
    private static final TAPPState INSTANCE = new TAPPState();

    /**
     * @return Singleton instance.
     */
    public static TAPPState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E' -> ObjectVerb.TAP;
            default -> null;
        });
    }
}
