package tegenton.card.parse.dfa.state.c.o.n.t.r.o;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.c.o.n.t.r.CONTROState;
import tegenton.card.parse.dfa.substring.StateSequence;
import tegenton.card.parse.lexicon.Morpheme;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.source.something.player.PlayerVerb;
import java.util.Optional;

public class CONTROLState extends CONTROState {
    private static final CONTROLState INSTANCE = new CONTROLState();

    public static CONTROLState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'L' -> new StateSequence("LER", Morpheme.ER);
            default -> throw new IllegalStateException("Cannot transition from CONTROLState on " + c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return switch (c) {
            case 'L', '\0', ' ' -> Optional.of(PlayerVerb.CONTROL);
            default -> Optional.empty();
        };
    }
}