package tegenton.card.parse.dfa.state.g;

import tegenton.card.parse.dfa.state.GState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CreatureType;
import java.util.Optional;

public class GOState extends GState {
    private static final GOState INSTANCE = new GOState();

    public static GOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'B' -> new SuffixSubstring("BLIN", CreatureType.GOBLIN);
            case 'L' -> new SuffixSubstring("LEM", CreatureType.GOLEM);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
