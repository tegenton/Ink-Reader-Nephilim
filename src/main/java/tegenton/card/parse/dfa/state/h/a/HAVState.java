package tegenton.card.parse.dfa.state.h.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.h.HAState;
import tegenton.card.parse.dfa.state.h.a.v.HAVEState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class HAVState extends HAState {
    private static final HAVState INSTANCE = new HAVState();

    public static HAVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> HAVEState.state();
            case 'I' -> new INGMorpheme();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'I' -> ObjectVerb.HAVE;
            default -> null;
        });
    }
}
