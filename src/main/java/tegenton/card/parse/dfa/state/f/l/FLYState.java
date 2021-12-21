package tegenton.card.parse.dfa.state.f.l;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.f.FLState;
import tegenton.card.parse.dfa.state.f.l.y.i.n.FLYINGState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class FLYState extends FLState {
    private static final FLYState INSTANCE = new FLYState();

    public static FLYState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new InfixSubstring("IN", 'G', FLYINGState::state);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
