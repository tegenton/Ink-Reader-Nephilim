package tegenton.card.parse.dfa.state.f.i.n.i.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.f.FIState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameVerb;

import java.util.Optional;

public class FINISHState extends FIState {
    private static final FINISHState INSTANCE = new FINISHState();

    public static FINISHState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("E", 'S', FINISHState::state);
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> GameVerb.FINISH;
            default -> null;
        });
    }
}
