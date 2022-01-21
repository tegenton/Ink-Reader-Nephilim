package tegenton.card.parse.dfa.state.h;

import tegenton.card.parse.dfa.state.HState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.h.a.HADState;
import tegenton.card.parse.dfa.state.h.a.HASState;
import tegenton.card.parse.dfa.state.h.a.HAVState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Genitive;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Zone;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class HAState extends HState {
    private static final HAState INSTANCE = new HAState();

    public static HAState state() {
        return INSTANCE;
    }

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

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D' -> ObjectVerb.HAVE;
            default -> null;
        });
    }
}
