package tegenton.card.parse.dfa.state.a;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Preposition;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;
import tegenton.card.parse.lexicon.game.source.target.TargetAdjective;

import java.util.Optional;

public class ABState extends AState {
    private static final ABState INSTANCE = new ABState();

    public static ABState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("ILITY", GameNoun.ABILITY);
            case 'L' -> new SuffixSubstring("LE", TargetAdjective.ABLE);
            case 'O' -> new SuffixSubstring("OVE", Preposition.ABOVE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
