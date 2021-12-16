package tegenton.card.parse.dfa.state.p;

import tegenton.card.parse.dfa.state.PState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.game.Keyword;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import java.util.Optional;

public class PRState extends PState {
    private static final PRState INSTANCE = new PRState();

    public static PRState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new SuffixSubstring("EVENT", PlayerVerb.PREVENT);
            case 'O' -> new SuffixSubstring("OTECTION", Keyword.PROTECTION);
            default -> throw new IllegalStateException(
                    "Cannot transition from PRState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
