package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.z.ZEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CreatureType;
import java.util.Optional;

public class ZState extends State {
    private static final ZState INSTANCE = new ZState();

    public static ZState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> ZEState.state();
            case 'O' -> new SuffixSubstring("OMBIE", CreatureType.ZOMBIE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
