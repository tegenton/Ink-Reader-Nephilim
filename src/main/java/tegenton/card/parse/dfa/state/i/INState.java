package tegenton.card.parse.dfa.state.i;

import tegenton.card.parse.dfa.state.IState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.n.INGState;
import tegenton.card.parse.dfa.state.i.n.INSState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import java.util.Optional;

public class INState extends IState {
    private static final INState INSTANCE = new INState();

    public static INState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> new SuffixSubstring("DESTRUCTIBLE",
                                            Keyword.INDESTRUCTIBLE);
            case 'G' -> INGState.state();
            case 'S' -> INSState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Preposition.IN);
            default -> Optional.empty();
        };
    }
}
