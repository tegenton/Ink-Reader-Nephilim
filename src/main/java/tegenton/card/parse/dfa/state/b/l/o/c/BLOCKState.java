package tegenton.card.parse.dfa.state.b.l.o.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.b.BLState;
import tegenton.card.parse.dfa.state.b.l.o.c.k.BLOCKEState;
import tegenton.card.parse.dfa.substring.morpheme.INGMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class BLOCKState extends BLState {
    private static final BLOCKState INSTANCE = new BLOCKState();

    public static BLOCKState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> BLOCKEState.state();
            case 'I' -> new INGMorpheme();
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', 'I', '\0', ' ' -> ObjectVerb.BLOCK;
            default -> null;
        });
    }
}