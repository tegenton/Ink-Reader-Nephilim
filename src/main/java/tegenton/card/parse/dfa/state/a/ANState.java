package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.n.ANDState;
import tegenton.card.parse.dfa.state.a.n.ANTState;
import tegenton.card.parse.dfa.state.a.n.ANYState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ANState extends AState {
    private static final ANState INSTANCE = new ANState();

    public static ANState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> ANDState.state();
            case 'T' -> ANTState.state();
            case 'O' -> new SuffixSubstring("OTHER", Determiner.ANOTHER);
            case 'Y' -> ANYState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Determiner.AN;
            default -> null;
        });
    }
}
