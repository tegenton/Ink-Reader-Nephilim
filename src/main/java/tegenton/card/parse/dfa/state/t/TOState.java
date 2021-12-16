package tegenton.card.parse.dfa.state.t;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.TState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.target.object.ObjectAttribute;
import tegenton.card.parse.lexicon.source.target.object.ObjectNoun;
import java.util.Optional;

public class TOState extends TState {
    private static final TOState INSTANCE = new TOState();

    public static TOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'K' -> new StateSequence("KEN", ObjectNoun.TOKEN);
            case 'U' -> new StateSequence("UGHNESS", ObjectAttribute.TOUGHNESS);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(Preposition.TO);
            default -> Optional.empty();
        };
    }
}
