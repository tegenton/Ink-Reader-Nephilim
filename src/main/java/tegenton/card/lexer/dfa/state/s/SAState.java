package tegenton.card.lexer.dfa.state.s;

import tegenton.card.lexer.dfa.state.SState;
import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.s.a.c.r.i.f.i.c.SACRIFICEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class SAState extends SState {
    private static final SAState INSTANCE = new SAState();

    /**
     * @return Singleton instance.
     */
    public static SAState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'C' -> new InfixSubstring("CRIFIC",
                    'E',
                    SACRIFICEState::state);
            case 'M' -> new SuffixSubstring("ME", Adjective.SAME);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
