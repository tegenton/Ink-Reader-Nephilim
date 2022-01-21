package tegenton.card.parse.dfa.state.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.s.a.c.r.i.f.i.c.SACRIFICEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class SAState extends SState {
    private static final SAState INSTANCE = new SAState();

    public static SAState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new InfixSubstring("CRIFIC", 'E', SACRIFICEState::state);
            case 'M' -> new SuffixSubstring("ME", Adjective.SAME);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
