package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.m.MAState;
import tegenton.card.parse.dfa.state.m.MIState;
import tegenton.card.parse.dfa.state.m.MOState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CreatureType;

import java.util.Optional;

public class MState extends State {
    private static final MState INSTANCE = new MState();

    /**
     * @return Singleton instance.
     */
    public static MState state() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public State transition(final char c) {
        return switch (c) {
            case 'A' -> MAState.state();
            case 'E' -> new SuffixSubstring("ERFOLK", CreatureType.MERFOLK);
            case 'I' -> MIState.state();
            case 'O' -> MOState.state();
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
