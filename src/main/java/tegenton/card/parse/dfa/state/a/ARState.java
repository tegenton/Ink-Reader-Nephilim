package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.r.AREState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class ARState extends AState {
    private static final ARState INSTANCE = new ARState();

    public static ARState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> AREState.state();
            case 'T' -> new SuffixSubstring("TIFACT", CardType.ARTIFACT);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
