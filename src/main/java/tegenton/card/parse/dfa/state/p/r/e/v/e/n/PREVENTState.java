package tegenton.card.parse.dfa.state.p.r.e.v.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.p.PRState;
import tegenton.card.parse.dfa.substring.morpheme.EDMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;


public class PREVENTState extends PRState {
    private static final PREVENTState INSTANCE = new PREVENTState();

    public static PREVENTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> new EDMorpheme();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'E', '\0', ' ' -> PlayerVerb.PREVENT;
            default -> null;
        });
    }
}
