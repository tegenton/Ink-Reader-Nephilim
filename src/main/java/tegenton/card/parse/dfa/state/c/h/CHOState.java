package tegenton.card.parse.dfa.state.c.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.CHState;
import tegenton.card.parse.dfa.state.c.h.o.o.s.CHOOSEState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Adjective;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class CHOState extends CHState {
    private static final CHOState INSTANCE = new CHOState();

    public static CHOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'I' -> new SuffixSubstring("ICE", Noun.CHOICE);
            case 'O' -> new InfixSubstring("OS", 'E', CHOOSEState::state);
            case 'S' -> new SuffixSubstring("SEN", Adjective.CHOSEN);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.empty();
    }
}
