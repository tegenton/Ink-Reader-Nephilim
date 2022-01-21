package tegenton.card.parse.dfa.state.w.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.w.WAState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class WASState extends WAState {
    private static final WASState INSTANCE = new WASState();

    public static WASState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("N\u2019T", Adverb.NOT);
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case 'N', '\0', ' ' -> Morpheme.ED;
            default -> null;
        });
    }
}
