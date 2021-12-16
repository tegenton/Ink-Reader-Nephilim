package tegenton.card.parse.dfa.state.d;

import tegenton.card.parse.dfa.state.DState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.SourceVerb;
import java.util.Optional;

public class DOState extends DState {
    private static final DOState INSTANCE = new DOState();

    public static DOState state() {
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
        return switch (c) {
            case '\0', ' ' -> Optional.of(SourceVerb.DO);
            default -> Optional.empty();
        };
    }
}
