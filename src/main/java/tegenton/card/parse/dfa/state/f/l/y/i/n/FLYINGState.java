package tegenton.card.parse.dfa.state.f.l.y.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.f.l.FLYState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Keyword;

import java.util.Optional;

public class FLYINGState extends FLYState {
    private static final FLYINGState INSTANCE = new FLYINGState();

    public static FLYINGState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case ',', ';', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case ',', '\0', ';', ' ' -> Keyword.FLYING;
            default -> null;
        });
    }
}