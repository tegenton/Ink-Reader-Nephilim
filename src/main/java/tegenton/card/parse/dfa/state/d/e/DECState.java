package tegenton.card.parse.dfa.state.d.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.d.DEState;
import tegenton.card.parse.dfa.state.d.e.c.DECKState;
import tegenton.card.parse.dfa.state.d.e.c.l.a.DECLARState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class DECState extends DEState {
    private static final DECState INSTANCE = new DECState();

    public static DECState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'K' -> DECKState.state();
            case 'L' -> new InfixSubstring("LA", 'R', DECLARState::state);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}
