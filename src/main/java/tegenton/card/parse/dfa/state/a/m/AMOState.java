package tegenton.card.parse.dfa.state.a.m;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.AMState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class AMOState extends AMState {
    private static final AMOState INSTANCE = new AMOState();

    public static AMOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NG", Preposition.AMONG);
            case 'U' -> new SuffixSubstring("UNT", Noun.AMOUNT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
