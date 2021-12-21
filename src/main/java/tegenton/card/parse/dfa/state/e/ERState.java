package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetModifier;

import java.util.Optional;

public class ERState extends EState {
    private static final ERState INSTANCE = new ERState();

    public static ERState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\u2019' -> new SuffixSubstring("\u2019S", TargetModifier.POSSESSIVE);
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Morpheme.ER;
            default -> null;
        });
    }
}
