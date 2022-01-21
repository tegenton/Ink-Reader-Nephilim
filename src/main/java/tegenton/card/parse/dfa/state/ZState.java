package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.z.ZEState;
import tegenton.card.parse.dfa.state.z.o.m.b.i.ZOMBIEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class ZState extends State {
    private static final ZState INSTANCE = new ZState();

    public static ZState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> ZEState.state();
            case 'O' -> new InfixSubstring("OMBI", 'E', ZOMBIEState::state);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
