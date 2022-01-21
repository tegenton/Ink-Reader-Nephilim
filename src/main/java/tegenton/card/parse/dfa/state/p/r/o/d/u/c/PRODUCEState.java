package tegenton.card.parse.dfa.state.p.r.o.d.u.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.e.EDState;
import tegenton.card.parse.dfa.state.p.r.PROState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class PRODUCEState extends PROState {
    private static final PRODUCEState INSTANCE = new PRODUCEState();

    public static PRODUCEState state() {
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
            case 'D', '\0', ' ' -> SourceVerb.PRODUCE;
            default -> null;
        });
    }
}
