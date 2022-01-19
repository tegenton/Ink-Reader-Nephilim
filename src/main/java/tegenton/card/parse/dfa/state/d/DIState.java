package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.i.DIEState;
import tegenton.card.parse.dfa.state.d.i.s.c.a.r.DISCARDState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DIState extends DState {
    private static final DIState INSTANCE = new DIState();

    public static DIState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'D' -> DOState.state();
            case 'E' -> DIEState.state();
            case 'F' -> new SuffixSubstring("FFERENT", Adjective.DIFFERENT);
            case 'S' -> new InfixSubstring("SCAR", 'D', DISCARDState::state);
            case 'V' -> new SuffixSubstring("VIDE", PlayerVerb.DIVIDE);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
