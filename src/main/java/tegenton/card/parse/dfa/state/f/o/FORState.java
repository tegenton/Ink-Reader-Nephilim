package tegenton.card.parse.dfa.state.f.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.FOState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.LandType;

import java.util.Optional;

public class FORState extends FOState {
    private static final FORState INSTANCE = new FORState();

    public static FOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("EST", LandType.FOREST);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Preposition.FOR;
            default -> null;
        });
    }
}
