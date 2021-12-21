package tegenton.card.parse.dfa.state.b.e.c.o.m;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.BEState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;

import java.util.Optional;

public class BECOMEState extends BEState {
    private static final BECOMEState INSTANCE = new BECOMEState();

    public static BECOMEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> this;
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> ObjectVerb.BECOME;
            default -> null;
        });
    }
}
