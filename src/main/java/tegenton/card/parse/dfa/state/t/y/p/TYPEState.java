package tegenton.card.parse.dfa.state.t.y.p;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

import java.util.Optional;

public class TYPEState extends TState {
    private static final TYPEState INSTANCE = new TYPEState();

    public static TYPEState state() {
        return INSTANCE;
    }

    public State transition(char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    public Optional<Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', '.', ' ' -> GameNoun.TYPE;
            default -> null;
        });
    }
}
