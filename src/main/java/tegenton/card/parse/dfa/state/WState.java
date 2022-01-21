package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.w.WAState;
import tegenton.card.parse.dfa.state.w.WHState;
import tegenton.card.parse.dfa.state.w.WOState;
import tegenton.card.parse.dfa.state.w.i.t.WITHState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Color;
import tegenton.card.parse.lexicon.game.GameVerb;

import java.util.Optional;

public class WState extends State {
    private static final WState INSTANCE = new WState();

    public static State state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> WAState.state();
            case 'E' -> new SuffixSubstring("ERE", Morpheme.ED);
            case 'H' -> WHState.state();
            case 'I' -> new InfixSubstring("IT", 'H', WITHState::state);
            case 'O' -> WOState.state();
            case '}' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E' -> GameVerb.BE;
            case '}', '\0', ' ' -> Color.W;
            default -> null;
        });
    }
}
