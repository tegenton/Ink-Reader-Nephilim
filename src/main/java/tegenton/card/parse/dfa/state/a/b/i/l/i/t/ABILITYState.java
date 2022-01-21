package tegenton.card.parse.dfa.state.a.b.i.l.i.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.b.i.l.i.ABILITState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

import java.util.Optional;

public class ABILITYState extends ABILITState {
    private static final ABILITYState INSTANCE = new ABILITYState();

    public static ABILITYState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', '.', ' ' -> GameNoun.ABILITY;
            default -> null;
        });
    }
}
