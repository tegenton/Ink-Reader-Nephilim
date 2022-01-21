package tegenton.card.parse.dfa.state.c.o.l.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.c.COState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Comparative;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

import java.util.Optional;

public class COLORState extends COState {
    private static final COLORState INSTANCE = new COLORState();

    public static COLORState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> new SuffixSubstring("LESS", Comparative.LESS);
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'L', '\0', '.', ' ' -> GameNoun.COLOR;
            default -> null;
        });
    }
}
