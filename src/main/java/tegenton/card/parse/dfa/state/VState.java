package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.object.ObjectAttribute;
import java.util.Optional;

public class VState extends State {
    private static final VState INSTANCE = new VState();

    public static VState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new StateSequence("ALUE", ObjectAttribute.VALUE);
            case 'I' -> new StateSequence("IGILANCE", Keyword.VIGILANCE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
