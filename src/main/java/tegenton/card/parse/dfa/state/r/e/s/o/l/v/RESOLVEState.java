package tegenton.card.parse.dfa.state.r.e.s.o.l.v;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.r.e.s.o.l.RESOLVState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.SourceVerb;

import java.util.Optional;

public class RESOLVEState extends RESOLVState {
    private static final RESOLVEState INSTANCE = new RESOLVEState();

    public static RESOLVEState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'S' -> this;
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> SourceVerb.RESOLVE;
            default -> null;
        });
    }
}
