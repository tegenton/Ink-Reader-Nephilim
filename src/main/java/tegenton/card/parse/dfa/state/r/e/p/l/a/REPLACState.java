package tegenton.card.parse.dfa.state.r.e.p.l.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.r.REState;
import tegenton.card.parse.dfa.state.r.e.p.l.a.c.REPLACEState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REPLACState extends REState {
    private static final REPLACState INSTANCE = new REPLACState();

    public static REPLACState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> REPLACEState.state();
            case 'I' -> new INGMorpheme();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'I' -> PlayerVerb.REPLACE;
            default -> null;
        });
    }
}
