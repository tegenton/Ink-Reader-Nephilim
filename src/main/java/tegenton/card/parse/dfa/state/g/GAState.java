package tegenton.card.parse.dfa.state.g;

import tegenton.card.parse.dfa.state.GState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class GAState extends GState {
    private static final GAState INSTANCE = new GAState();

    public static GAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("IN", TargetVerb.GAIN);
            case 'M' -> new SuffixSubstring("ME", GameNoun.GAME);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
