package tegenton.card.parse.dfa.state.i.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.i.INState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;
import tegenton.card.parse.lexicon.game.type.CreatureType;
import java.util.Optional;

public class INSState extends INState {
    private static final INSState INSTANCE = new INSState();

    public static INSState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("ECT", CreatureType.INSECT);
            case 'T' -> new SuffixSubstring("TANT", CardType.INSTANT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}