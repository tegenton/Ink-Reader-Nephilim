package tegenton.card.parse.dfa.state.t.u.r;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

import java.util.Optional;

public class TURNState extends TState {
    private static final TURNState INSTANCE = new TURNState();

    public static TURNState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            case 'S' -> SState.state();
            case ',', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', 'S', ',', '\0', '.', ' ' -> GameNoun.TURN;
            default -> null;
        });
    }
}
