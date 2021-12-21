package tegenton.card.parse.dfa.state.c.a.n.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.a.n.CANtState;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CANTState extends CANtState {
    private static final CANTState INSTANCE = new CANTState();

    public static CANTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
