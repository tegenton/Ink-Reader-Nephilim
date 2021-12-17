package tegenton.card.parse.dfa.state.m.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.a.MANState;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.GameNoun;

import java.util.Optional;

public class MANAState extends MANState {
    private static final MANAState INSTANCE = new MANAState();

    public static MANAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> GameNoun.MANA;
            default -> null;
        });
    }
}
