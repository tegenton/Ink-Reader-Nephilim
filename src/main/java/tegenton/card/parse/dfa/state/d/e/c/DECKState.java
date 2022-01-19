package tegenton.card.parse.dfa.state.d.e.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.d.e.DECState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.Zone;

import java.util.Optional;

public class DECKState extends DECState {
    private static final DECKState INSTANCE = new DECKState();

    public static DECKState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Zone.DECK;
            default -> null;
        });
    }
}
