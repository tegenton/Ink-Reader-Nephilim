package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.w.WAState;
import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.dfa.state.w.WOState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;

import java.util.Optional;

public class WState extends State {
    private static final WState INSTANCE = new WState();

    public static State state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> WAState.state();
            case 'H' -> WHState.state();
            case 'I' -> new SuffixSubstring("ITH", Preposition.WITH);
            case 'O' -> WOState.state();
            case '}' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '}' -> Color.W;
            default -> null;
        });
    }
}
