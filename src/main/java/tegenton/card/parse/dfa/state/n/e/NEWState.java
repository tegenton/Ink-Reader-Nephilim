package tegenton.card.parse.dfa.state.n.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.n.NEState;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class NEWState extends NEState {
    private static final NEWState INSTANCE = new NEWState();

    public static NEWState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Adjective.NEW;
            default -> null;
        });
    }
}
