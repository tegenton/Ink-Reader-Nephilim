package tegenton.card.parse.dfa.state.t.a.p;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.t.a.TAPState;
import tegenton.card.parse.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class TAPPState extends TAPState {
    private static final TAPPState INSTANCE = new TAPPState();

    public static TAPPState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E' -> ObjectVerb.TAP;
            default -> null;
        });
    }
}
