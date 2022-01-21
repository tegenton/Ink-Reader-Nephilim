package tegenton.card.parse.dfa.state.d.e.c.l.a.r;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.e.c.l.a.DECLARState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class DECLAREState extends DECLARState {
    private static final DECLAREState INSTANCE = new DECLAREState();

    public static DECLAREState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'D' -> EDState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'D', '\0', ' ' -> PlayerVerb.DECLARE;
            default -> null;
        });
    }
}
