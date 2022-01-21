package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.v.VIState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;

import java.util.Optional;

public class VState extends State {
    private static final VState INSTANCE = new VState();

    public static VState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ALUE", ObjectAttribute.VALUE);
            case 'I' -> VIState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
