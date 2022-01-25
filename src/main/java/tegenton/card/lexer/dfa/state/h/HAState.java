package tegenton.card.lexer.dfa.state.h;

import tegenton.card.lexer.dfa.state.HState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.h.a.HADState;
import tegenton.card.lexer.dfa.state.h.a.HASState;
import tegenton.card.lexer.dfa.state.h.a.HAVState;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Genitive;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class HAState extends HState {
    private static final HAState INSTANCE = new HAState();

    /**
     * @return Singleton instance.
     */
    public static HAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> HADState.state();
            case 'L' -> new SuffixSubstring("LF", Genitive.HALF);
            case 'N' -> new SuffixSubstring("ND", Zone.HAND);
            case 'S' -> HASState.state();
            case 'V' -> HAVState.state();
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D' -> ObjectVerb.HAVE;
            default -> null;
        });
    }
}
