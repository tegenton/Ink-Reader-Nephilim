package tegenton.card.parse.dfa.state.a.c.t.i;

import tegenton.card.parse.dfa.state.AState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.a.c.t.i.v.ACTIVATEState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class ACTIVState extends AState {
    private static final ACTIVState INSTANCE = new ACTIVState();

    public static ACTIVState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> new SuffixSubstring("ATE", PlayerVerb.ACTIVATE);
            case 'E' -> ACTIVATEState.state();
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
