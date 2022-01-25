package tegenton.card.lexer.dfa.state.c.h;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.c.CHState;
import tegenton.card.lexer.dfa.state.c.h.o.o.s.CHOOSEState;
import tegenton.card.lexer.dfa.substring.InfixSubstring;
import tegenton.card.lexer.dfa.substring.SuffixSubstring;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class CHOState extends CHState {
    private static final CHOState INSTANCE = new CHOState();

    /**
     * @return Singleton instance.
     */
    public static CHOState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("ICE", Noun.CHOICE);
            case 'O' -> new InfixSubstring("OS", 'E', CHOOSEState::state);
            case 'S' -> new SuffixSubstring("SEN", Adjective.CHOSEN);
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
