package tegenton.card.parse.dfa.state.r.e.s;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.r.e.RESState;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class RESTState extends RESState {
    private static final RESTState INSTANCE = new RESTState();

    public static RESTState state() {
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
            case '\0', ' ' -> Noun.REST;
            default -> null;
        });
    }
}
