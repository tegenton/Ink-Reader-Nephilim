package tegenton.card.lexer.dfa.state.h.a;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.h.HAState;
import tegenton.card.lexer.dfa.state.h.a.v.HAVEState;
import tegenton.card.lexer.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class HAVState extends HAState {
    private static final HAVState INSTANCE = new HAVState();

    /**
     * @return Singleton instance.
     */
    public static HAVState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> HAVEState.state();
            case 'I' -> new INGMorpheme();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'I' -> ObjectVerb.HAVE;
            default -> null;
        });
    }
}
