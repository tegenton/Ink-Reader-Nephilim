package tegenton.card.parse.dfa.state.r.e.p.l.a.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.r.e.p.l.a.REPLACState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class REPLACEState extends REPLACState {
    private static final REPLACEState INSTANCE = new REPLACEState();

    public static REPLACEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> PlayerVerb.REPLACE;
            default -> null;
        });
    }
}
