package tegenton.card.parse.dfa.state.c.a.u.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.CAState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameVerb;

import java.util.Optional;

public class CAUSEState extends CAState {
    private static final CAUSEState INSTANCE = new CAUSEState();

    public static CAUSEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> GameVerb.CAUSE;
            default -> null;
        });
    }
}