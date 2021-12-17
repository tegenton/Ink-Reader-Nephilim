package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.SubordinateConjunction;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class ASState extends AState {
    private static final ASState INSTANCE = new ASState();

    public static ASState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> new SuffixSubstring("SIGN", TargetVerb.ASSIGN);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(SubordinateConjunction.AS);
            default -> Optional.empty();
        };
    }
}
