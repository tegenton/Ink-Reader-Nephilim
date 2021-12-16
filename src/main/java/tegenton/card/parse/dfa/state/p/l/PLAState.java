package tegenton.card.parse.dfa.state.p.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.p.PLState;
import tegenton.card.parse.dfa.state.p.l.a.PLAYState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.type.CardType;
import java.util.Optional;

public class PLAState extends PLState {
    private static final PLAState INSTANCE = new PLAState();

    public static PLAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NESWALKER", CardType.PLANESWALKER);
            case 'Y' -> PLAYState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
