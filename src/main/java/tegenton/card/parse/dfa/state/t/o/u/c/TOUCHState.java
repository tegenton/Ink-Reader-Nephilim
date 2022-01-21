package tegenton.card.parse.dfa.state.t.o.u.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.t.o.TOUState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameVerb;

import java.util.Optional;

public class TOUCHState extends TOUState {
    private static final TOUCHState INSTANCE = new TOUCHState();

    public static TOUCHState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'E' -> new InfixSubstring("E", 'S', TOUCHState::state);
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> GameVerb.TOUCH;
            default -> null;
        });
    }
}