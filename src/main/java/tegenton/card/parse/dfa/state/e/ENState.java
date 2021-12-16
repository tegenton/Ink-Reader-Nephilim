package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.object.ObjectVerb;
import java.util.Optional;

public class ENState extends EState {
    private static final ENState INSTANCE = new ENState();

    public static ENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'C' -> new StateSequence("CHANT", Keyword.ENCHANT);
            case 'T' -> new StateSequence("TER", ObjectVerb.ENTER);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
