package tegenton.card.parse.dfa.state.a.r.t.i.f.a.c;

import tegenton.card.parse.dfa.state.PossessiveState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ARState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class ARTIFACTState extends ARState {
    private static final ARTIFACTState INSTANCE = new ARTIFACTState();

    public static ARTIFACTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\u2019' -> PossessiveState.state();
            case ',', '\n', '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\u2019', ',', '\n', '\0', '.', ' ' -> CardType.ARTIFACT;
            default -> null;
        });
    }
}
