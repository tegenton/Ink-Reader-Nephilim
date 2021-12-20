package tegenton.card.parse.dfa.state.b.e.g.i;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.b.BEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parse.lexicon.game.turn.Phase;

import java.util.Optional;

public class BEGINState extends BEState {
    private static final BEGINState INSTANCE = new BEGINState();

    public static BEGINState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'N' -> new SuffixSubstring("NING", Phase.BEGINNING);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> PlayerVerb.BEGIN;
            default -> null;
        });
    }
}
