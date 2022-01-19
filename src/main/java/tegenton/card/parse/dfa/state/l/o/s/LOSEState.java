package tegenton.card.parse.dfa.state.l.o.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.l.o.LOSState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;

import java.util.Optional;

public class LOSEState extends LOSState {
    private static final LOSEState INSTANCE = new LOSEState();

    public static LOSEState state() {
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
            case '\0', ' ' -> TargetVerb.LOSE;
            default -> null;
        });
    }
}
