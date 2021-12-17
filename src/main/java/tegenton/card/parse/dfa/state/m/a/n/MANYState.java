package tegenton.card.parse.dfa.state.m.a.n;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.m.a.MANState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class MANYState extends MANState {
    private static final MANYState INSTANCE = new MANYState();

    public static MANYState state() {
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
            case '\0', ' ' -> Determiner.MANY;
            default -> null;
        });
    }
}
