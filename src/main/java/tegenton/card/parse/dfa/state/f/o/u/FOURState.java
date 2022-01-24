package tegenton.card.parse.dfa.state.f.o.u;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.SymbolState;
import tegenton.card.parse.dfa.state.f.o.FOUState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.value.EnglishNumber;

import java.util.Optional;

public class FOURState extends FOUState {
    private static final FOURState INSTANCE = new FOURState();

    /**
     * @return Singleton instance.
     */
    public static FOURState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'T' -> new TEENMorpheme(EnglishNumber.FOUR);
            case '\0', ' ' -> SymbolState.state(c);
            default -> invalid(c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> EnglishNumber.FOUR;
            default -> null;
        });
    }
}
