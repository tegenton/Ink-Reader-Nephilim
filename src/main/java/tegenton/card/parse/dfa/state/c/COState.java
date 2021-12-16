package tegenton.card.parse.dfa.state.c;

import tegenton.card.parse.dfa.state.CState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.CONState;
import tegenton.card.parse.dfa.state.c.o.COUState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.source.target.object.ObjectVerb;
import java.util.Optional;

public class COState extends CState {
    private static final COState INSTANCE = new COState();

    public static COState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> CONState.state();
            case 'P' -> new SuffixSubstring("PY", ObjectNoun.COPY);
            case 'S' -> new SuffixSubstring("ST", ObjectVerb.COST);
            case 'U' -> COUState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
