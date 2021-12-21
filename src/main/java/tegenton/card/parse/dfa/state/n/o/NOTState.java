package tegenton.card.parse.dfa.state.n.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.n.NOState;
import tegenton.card.parse.lexicon.Adverb;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class NOTState extends NOState {
    private static final NOTState INSTANCE = new NOTState();

    public static NOTState state() {
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
            case '\0', ' ' -> Adverb.NOT;
            default -> null;
        });
    }
}
