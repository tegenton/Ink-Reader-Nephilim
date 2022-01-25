package tegenton.card.lexer.dfa.state.e.l.e.v.e;

import tegenton.card.lexer.dfa.state.State;
import tegenton.card.lexer.dfa.state.e.l.e.v.ELEVEState;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.lexicon.Word;

import java.util.Optional;

public class ELEVENState extends ELEVEState {
    private static final ELEVENState INSTANCE = new ELEVENState();

    /**
     * @return Singleton instance.
     */
    public static ELEVENState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        switch (c) {
            default -> throw new IllegalStateException(
                    "Cannot transition from ELEVENState on " + c);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<? extends Word> produce(final char c) {
        return switch (c) {
            case '\0', '0' -> Optional.of(EnglishNumber.ELEVEN);
            default -> Optional.empty();
        };
    }
}
