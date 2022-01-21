package tegenton.card.parse.dfa.state.p.e.r.m.a.n.e.n;

import tegenton.card.parse.dfa.state.PState;
import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;

import java.util.Optional;

public class PERMANENTState extends PState {
    private static final PERMANENTState INSTANCE = new PERMANENTState();

    public static PERMANENTState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'S' -> SState.state();
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case 'S', '\0', '.', ' ' -> ObjectNoun.PERMANENT;
            default -> null;
        });
    }
}
