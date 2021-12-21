package tegenton.card.parse.dfa.state.e.a.c;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.e.a.EACState;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class EACHState extends EACState {
    private static final EACHState instance = new EACHState();

    public static EACHState state() {
        return instance;
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
            case '\0', ' ' -> Determiner.EACH;
            default -> null;
        });
    }
}
