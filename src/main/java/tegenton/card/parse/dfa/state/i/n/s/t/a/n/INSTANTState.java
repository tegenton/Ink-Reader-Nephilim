package tegenton.card.parse.dfa.state.i.n.s.t.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.s.t.a.INSTANState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class INSTANTState extends INSTANState {
    private static final INSTANTState INSTANCE = new INSTANTState();

    public static INSTANTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> CardType.INSTANT;
            default -> null;
        });
    }
}
