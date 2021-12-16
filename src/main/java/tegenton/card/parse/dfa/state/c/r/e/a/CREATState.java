package tegenton.card.parse.dfa.state.c.r.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.r.e.CREAState;
import tegenton.card.parse.dfa.state.c.r.e.a.t.CREATEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;
import java.util.Optional;

public class CREATState extends CREAState {

    private static final CREATState INSTANCE = new CREATState();

    public static CREATState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> CREATEState.state();
            case 'U' -> new SuffixSubstring("URE", CardType.CREATURE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
