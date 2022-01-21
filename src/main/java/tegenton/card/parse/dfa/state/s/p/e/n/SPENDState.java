package tegenton.card.parse.dfa.state.s.p.e.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.s.p.e.SPENState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class SPENDState extends SPENState {
    private static final SPENDState INSTANCE = new SPENDState();

    public static SPENDState state() {
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
            case '\0', ' ' -> PlayerVerb.SPEND;
            default -> null;
        });
    }
}
