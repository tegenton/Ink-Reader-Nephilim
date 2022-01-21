package tegenton.card.parse.dfa.state.a.t.t.a.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.t.t.a.ATTACState;
import tegenton.card.parse.dfa.state.a.t.t.a.c.k.ATTACKEState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class ATTACKState extends ATTACState {
    private static final ATTACKState INSTANCE = new ATTACKState();

    public static ATTACKState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ATTACKEState.state();
            case 'I' -> new INGMorpheme();
            case 'S' -> this;
            case ',', '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', 'I', ',', '\0', ' ' -> ObjectVerb.ATTACK;
            default -> null;
        });
    }
}
