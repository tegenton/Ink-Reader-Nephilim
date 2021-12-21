package tegenton.card.parse.dfa.state.m;

import tegenton.card.parse.dfa.state.MState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.o.MORState;
import tegenton.card.parse.dfa.state.m.o.u.n.t.a.i.MOUNTAINState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class MOState extends MState {
    private static final MOState INSTANCE = new MOState();

    public static MOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> MORState.state();
            case 'U' -> new InfixSubstring("UNTAI", 'N', MOUNTAINState::state);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
