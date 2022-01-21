package tegenton.card.parse.dfa.state.s.e.v.e;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.s.e.v.SEVEState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.EnglishNumber;

import java.util.Optional;

public class SEVENState extends SEVEState {
    private static final SEVENState INSTANCE = new SEVENState();

    public static SEVENState state() {
        return INSTANCE;
    }

    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.SEVEN);
            case '\0', '.', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', '.', ' ' -> EnglishNumber.SEVEN;
            default -> null;
        });
    }
}
