package tegenton.card.parse.dfa.state.a.d;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.a.ADState;
import tegenton.card.parse.dfa.state.a.d.d.i.t.i.o.ADDITIONState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.player.PlayerVerb;

import java.util.Optional;

public class ADDState extends ADState {
    private static final ADDState INSTANCE = new ADDState();

    public static ADDState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new InfixSubstring("ITIO", 'N', ADDITIONState::state);
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> PlayerVerb.ADD;
            default -> null;
        });
    }
}
