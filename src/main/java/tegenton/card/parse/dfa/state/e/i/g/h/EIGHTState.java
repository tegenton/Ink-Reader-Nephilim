package tegenton.card.parse.dfa.state.e.i.g.h;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.e.i.g.EIGHState;
import tegenton.card.parse.dfa.substring.morpheme.TEENMorpheme;
import tegenton.card.parse.lexicon.value.EnglishNumber;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

public class EIGHTState extends EIGHState {
    private static final EIGHTState INSTANCE = new EIGHTState();

    /**
     * @return Singleton instance.
     */
    public static EIGHTState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'E' -> {
                final TEENMorpheme teen = new TEENMorpheme(EnglishNumber.EIGHT);
                teen.transition('E');
                yield teen;
            }
            default -> throw new IllegalStateException(
                    "Cannot transition from EIGHTState on " + c);
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', ' ' -> Optional.of(EnglishNumber.EIGHT);
            default -> Optional.empty();
        };
    }
}
