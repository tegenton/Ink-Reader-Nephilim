package tegenton.card.parse.dfa.state.e;

import tegenton.card.parse.dfa.state.EState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Zone;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import java.util.Optional;

public class EXState extends EState {
    private static final EXState INSTANCE = new EXState();

    public static EXState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'C' -> new SuffixSubstring("CHANGE", PlayerVerb.EXCHANGE);
            case 'I' -> new SuffixSubstring("ILE", Zone.EXILE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
