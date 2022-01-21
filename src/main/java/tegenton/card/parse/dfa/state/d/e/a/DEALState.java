package tegenton.card.parse.dfa.state.d.e.a;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.dfa.state.d.e.a.l.DEALTState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class DEALState extends DEState {
    private static final DEALState INSTANCE = new DEALState();

    public static DEALState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> this;
            case 'T' -> DEALTState.state();
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'T', '\0', ' ' -> SourceVerb.DEAL;
            default -> null;
        });
    }
}
